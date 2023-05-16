<template>
    <div
        class="map-viewport"
        ref="viewport"
        @pointerdown="onPointerDown"
        @pointermove="onPointerMove"
        @pointerup="onPointerUp"
        @pointerenter="onPointerEnter"
        @pointerleave="e => { onPointerLeave(e); onPointerUp(e) }"
        @wheel="onWheel"
    ></div>
</template>

<style scoped lang="scss">
.map-viewport {
    width: 100%;
    height: 100%;
    position: relative;
    overflow: hidden;
}   
</style>

<script setup lang="ts">
import { onMounted, ref, watch } from 'vue';
import {
    Application,
    Container, Sprite, Graphics, DisplayObject,
    ISVGResourceOptions, MIPMAP_MODES, Rectangle, Point,
    AlphaFilter,
} from 'pixi.js';
import { OutlineFilter } from '@pixi/filter-outline';
import { MapDomainSchema, MapObjectSchema } from '../schemas/map-schemas';
import { useNavStore } from '../stores/nav-store';
import LocSelectorIcon from '../assets/location-select.svg';

// Параметры компонента
const ZOOM_STEP = 1 / 500
const MIN_ZOOM = 0.8
const MAX_ZOOM = 5
const ZOOM_FACTOR = 15
const SVG_PIXELS_PER_METER = 18.0
const OBJECT_CLICK_DELAY = 200
const OBJECT_FILTERS = [
    new AlphaFilter(0.0)
]
const SELECTED_OBJECT_FILTERS = [
    new OutlineFilter(8, 0x0d6efd, 0.25, 0.5, true)
]
const LOCATION_POINT_SIZE = 48
const ACTIVE_LOCATION_POINT_COLOR = 0x0d6efd
const UNACTIVE_LOCATION_POINT_COLOR = 0x6c757d

// Экземпляр приложения pixi.js
const pixiApp = new Application({
    background: 0xFFFFFF
})
// Контейнер, содержащий все объекты
const pixiRoot = new Container()

// Спрайт с иконкой выбора позиции
const pixiLocationPoint = Sprite.from(LocSelectorIcon, {
    resourceOptions: {
        width: LOCATION_POINT_SIZE
    }
})
pixiLocationPoint.width = LOCATION_POINT_SIZE
pixiLocationPoint.height = LOCATION_POINT_SIZE
pixiLocationPoint.anchor.set(0.5, 1.0)

// HTML элемент, содержащий canvas для отрисовки
const viewport = ref<HTMLElement | null>(null)
// Наблюдатель изменения размеров viewport
const resizeObserver = new ResizeObserver(onResize)

// Позиция виртуальной камеры
let viewPosX = 0.0
let viewPosY = 0.0
// Степень приближения
let viewZoom = 1.0
// Словарь с объектами на карте.
// Ключ - id объекта, значение - отрисовываемый объект 
let mapObjects = new Map<number, DisplayObject>()

// Позиция курсора в предыдущем событии перемещения
let lastPointerX = 0.0
let lastPointerY = 0.0
// id текущего курсора
let pointerId: number | null = null
// "тащиться" ли карта в данный момент курсором
let isDragging = false

// id курсора, нажатого на объекте
let objectPointerId: number | null = null
// Время нажатия объекта
let objectPointerDownTime = 0.0

// id объектов, которые находятся под курсором пользователя
let focusedObjects = new Set<number>()

function getZoom() {
    return viewZoom
}

function setZoom(value: number) {
    viewZoom = value
    pixiUpdateRootTransform()
}

function onPointerDown(e: PointerEvent) {
    if (e.button === 0 && pointerId === null) {
        pointerId = e.pointerId
        isDragging = true
        lastPointerX = e.offsetX
        lastPointerY = e.offsetY
    }
}

function onPointerMove(e: PointerEvent) {
    let deltaX = e.offsetX - lastPointerX
    let deltaY = e.offsetY - lastPointerY

    lastPointerX = e.offsetX
    lastPointerY = e.offsetY

    if (isDragging && e.pointerId === e.pointerId) {
        let viewScale = viewZoom * ZOOM_FACTOR
        viewPosX -= (e.x - lastPointerX) / viewScale
        viewPosY -= (e.y - lastPointerY) / viewScale
        lastPointerX = e.x
        lastPointerY = e.y
        navStore.focusedObjectId = null
        pixiUpdateRootTransform()
    }

    if (navStore.isSelectingLocation) {
        pixiUpdateLocationPoint()
    }
}

function onPointerUp(e: PointerEvent) {
    if (e.pointerId !== e.pointerId) {
        return
    }

    if (e.button === 0 || e.type === 'pointerleave') {
        isDragging = false
        pointerId = null
    }
}

function onPointerEnter(e: PointerEvent) {
    if (navStore.isSelectingLocation) {
        pixiLocationPoint.renderable = true
    }
}

function onPointerLeave(e: PointerEvent) {
    if (navStore.isSelectingLocation) {
        pixiLocationPoint.renderable = false
    }
}

function onObjectClick(
    mapObject: MapObjectSchema,
    position: Point
) {
    if (navStore.isSelectingLocation) {
        navStore.location = {
            positionX: position.x,
            positionY: position.y,
            mapObject: {
                id: mapObject.id,
                mapBuildingId: navStore.buildingId ?? 0,
                mapDomainId: navStore.domain?.id ?? 0,
                type: mapObject.type,
                info: mapObject.info
            }
        }
        navStore.isSelectingLocation = false
        pixiUpdateMapObject(mapObject.id)
        return
    }

    navStore.selectedObjectId = mapObject.id
    emit('objectClick', mapObject)
}

function onObjectEnter(mapObject: MapObjectSchema) {
    focusedObjects.add(mapObject.id)

    if (navStore.isSelectingLocation) {
        pixiUpdateMapObject(mapObject.id)
        pixiUpdateLocationPoint()
    }
}

function onObjectLeave(mapObject: MapObjectSchema) {
    focusedObjects.delete(mapObject.id)

    if (navStore.isSelectingLocation) {
        pixiUpdateMapObject(mapObject.id)
        pixiUpdateLocationPoint()
    }
}

function onWheel(e: WheelEvent) {
    viewZoom -= e.deltaY * ZOOM_STEP
    pixiUpdateRootTransform()
}

function onResize() {
    pixiUpdateRootTransform()
}

function focusOnDomain() {
    let bounds = pixiRoot.getBounds()
    pixiFocusOnBounds(bounds)
}

function focusOnObject(id: number) {
    let bounds = mapObjects.get(id)?.getBounds()
    if (bounds !== undefined) {
        pixiFocusOnBounds(bounds)
    }
}

function recreatePixiObjects() {
    mapObjects.clear()
    while (pixiRoot.children.length > 0) {
        pixiRoot.children[0].destroy({ children: true })
    }
    
    let domains = new Array<MapDomainSchema>()
    if (navStore.domain !== null) {
        domains.push(navStore.domain)
    }

    for (let i = 0; i < domains.length; ++i) {
        pixiAddDomain(domains[i])
    }
}

function pixiAddDomain(domain: MapDomainSchema) {
    let sprite = Sprite.from(domain.image.url, {
        mipmap: MIPMAP_MODES.ON,
        resourceOptions: {
            width: domain.image.width * SVG_PIXELS_PER_METER,
            height: domain.image.height * SVG_PIXELS_PER_METER
        } as ISVGResourceOptions
    })

    sprite.width = domain.image.width
    sprite.height = domain.image.height
    sprite.x = domain.image.offsetX
    sprite.y = domain.image.offsetY
    
    pixiRoot.addChild(sprite)

    for (let i = 0; i < domain.mapObjects.length; ++i) {
        pixiAddMapObject(domain.mapObjects[i])
    }
}

function pixiAddMapObject(mapObject: MapObjectSchema) {
    let container = new Container()

    for (let k = 0; k < mapObject.bboxes.length; k++) {
        let bbox = mapObject.bboxes[k]

        let bounds = new Graphics()
        bounds.eventMode = 'static'
        bounds.beginFill(0x0)
        bounds.drawRect(bbox.positionX, bbox.positionY, bbox.width, bbox.height)
        bounds.endFill()
        bounds.hitArea = new Rectangle(
            bbox.positionX, bbox.positionY, bbox.width, bbox.height
        )
        bounds.on('pointerdown', (e) => {
            if (e.button === 0 && objectPointerId === null) {
                objectPointerId = e.pointerId
                objectPointerDownTime = e.timeStamp
            }
        })
        bounds.on('pointerup', (e) => {
            if (e.button === 0 && e.pointerId == objectPointerId) {
                objectPointerId = null
                if (e.timeStamp - objectPointerDownTime < OBJECT_CLICK_DELAY) {
                    onObjectClick(mapObject, e.global)
                }
            }
        })
        bounds.on('pointerenter', (e) => {
            onObjectEnter(mapObject)
        })
        bounds.on('pointerleave', (e) => {
            onObjectLeave(mapObject)
        })

        container.addChild(bounds)
    }

    pixiRoot.addChild(container)
    mapObjects.set(mapObject.id, container)

    pixiUpdateMapObject(mapObject.id)
}

function pixiUpdateRootTransform() {
    viewZoom = Math.min(Math.max(viewZoom, MIN_ZOOM), MAX_ZOOM)

    let viewScale = viewZoom * ZOOM_FACTOR

    pixiRoot.scale = new Point(viewScale, viewScale)
    pixiRoot.x = -viewPosX * viewScale + pixiApp.screen.width * 0.5
    pixiRoot.y = -viewPosY * viewScale + pixiApp.screen.height * 0.5
}

function pixiFocusOnBounds(bounds: Rectangle) {
    let viewScale = viewZoom * ZOOM_FACTOR

    viewPosX += (bounds.x - (pixiApp.screen.width - bounds.width) * 0.5) / viewScale
    viewPosY += (bounds.y - (pixiApp.screen.height - bounds.height) * 0.5) / viewScale
    pixiUpdateRootTransform()
}

function pixiUpdateMapObject(id: number) {
    let obj = mapObjects.get(id)
    if (obj === undefined) {
        return
    }

    if (id === navStore.selectedObjectId ||
        (navStore.isSelectingLocation && focusedObjects.has(id))
    ) {
        obj.filters = SELECTED_OBJECT_FILTERS
    } else {
        obj.filters = OBJECT_FILTERS
    }
}

function pixiUpdateLocationPoint() {
    pixiLocationPoint.visible = navStore.isSelectingLocation || navStore.location !== null

    if (navStore.isSelectingLocation) {
        pixiLocationPoint.position.set(lastPointerX, lastPointerY)
        pixiLocationPoint.tint = 
            focusedObjects.size > 0 ?
            ACTIVE_LOCATION_POINT_COLOR : 
            UNACTIVE_LOCATION_POINT_COLOR;
    } else {
        pixiLocationPoint.renderable = true
        pixiLocationPoint.position.set(
            navStore.location?.positionX, navStore.location?.positionY
        )
        pixiLocationPoint.tint = ACTIVE_LOCATION_POINT_COLOR
    }
}

function pixiUpdate(delta: number) {

}

const navStore = useNavStore()

defineExpose({ getZoom, setZoom })

const emit = defineEmits<{
    (e: 'objectClick', mapObject: MapObjectSchema): void
}>()

onMounted(() => {
    if (viewport.value !== null) {
        pixiApp.resizeTo = viewport.value
        
        let canvas = pixiApp.view as HTMLCanvasElement
        canvas.style.position = 'absolute'
        viewport.value.appendChild(canvas)
        resizeObserver.observe(canvas)
    }

    pixiUpdateRootTransform()
    pixiApp.stage.addChild(pixiRoot)
    pixiApp.stage.addChild(pixiLocationPoint)
    pixiApp.ticker.add(pixiUpdate)
})

watch(() => navStore.domain, (newVal, oldVal) => {
    recreatePixiObjects()
    if (navStore.focusedObjectId !== null) {
        focusOnObject(navStore.focusedObjectId)
    } else {
        focusOnDomain()
    }
}, { immediate: true} )

watch(() => navStore.selectedObjectId, (newId, oldId) => {
    if (oldId !== null) {
        pixiUpdateMapObject(oldId)
    }

    if (newId !== null) {
        pixiUpdateMapObject(newId)
    }
})

watch(() => navStore.focusedObjectId, (newId, oldId) => {
    if (newId !== null) {
        focusOnObject(newId)
    }
})

watch(() => navStore.isSelectingLocation, (newVal, oldVal) => {
    pixiUpdateLocationPoint()
}, { immediate: true })

watch(() => navStore.location, (newLoc, oldLoc) => {
    pixiUpdateLocationPoint()
}, { immediate: true })

</script>
