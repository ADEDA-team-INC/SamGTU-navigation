<template>
    <div
        class="map-viewport"
        ref="viewport"
        @pointerdown="onPointerDown"
        @pointermove="onPointerMove"
        @pointerup="onPointerUp"
        @pointerleave="onPointerUp"
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
    Application, Container, Sprite, Graphics, DisplayObject,
    Point, ISVGResourceOptions, MIPMAP_MODES, Rectangle,
    AlphaFilter
} from 'pixi.js';
import { OutlineFilter } from '@pixi/filter-outline';
import { MapDomainSchema, MapObjectSchema } from '../schemas/map-schemas';
import { useNavStore } from '../stores/nav-store';

const ZOOM_STEP = 1 / 500
const MIN_ZOOM = 0.8
const MAX_ZOOM = 5
const SVG_PIXELS_PER_METER = 4
const OBJECT_CLICK_DELAY = 200
const OBJECT_FILTERS = [
    new AlphaFilter(0.0)
]
const SELECTED_OBJECT_FILTERS = [
    new OutlineFilter(8, 0x0d6efd, 0.25, 0.5, true)
]

const navStore = useNavStore()

const emit = defineEmits<{
    (e: 'objectClick', mapObject: MapObjectSchema): void
}>()

const pixiApp = new Application({
    background: 0xFFFFFF
})
const pixiRoot = new Container()

const viewport = ref<HTMLElement | null>(null)
const resizeObserver = new ResizeObserver(onResize)

let viewPosX = 0.0
let viewPosY = 0.0
let viewZoom = 1.0
let mapObjects = new Map<number, DisplayObject>()

let lastPointerX = 0.0
let lastPointerY = 0.0
let pointerId: number | null = null
let isDragging = false
let objectPointerId: number | null = null
let objectPointerDownTime = 0.0
let selectedObjectId: number | null = null

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
        lastPointerX = e.x
        lastPointerY = e.y
    }
}

function onPointerMove(e: PointerEvent) {
    if (isDragging && e.pointerId === e.pointerId) {
        viewPosX -= (e.x - lastPointerX) / viewZoom
        viewPosY -= (e.y - lastPointerY) / viewZoom
        lastPointerX = e.x
        lastPointerY = e.y
        navStore.focusedObjectId = null
        pixiUpdateRootTransform()
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
    for (let i = 0; i < pixiRoot.children.length; ++i) {
        pixiRoot.children[i].destroy({
            children: true
        })
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
    container.filters =
        navStore.selectedObjectId == mapObject.id ?
        SELECTED_OBJECT_FILTERS :
        OBJECT_FILTERS;

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
                    navStore.selectedObjectId = mapObject.id
                    emit('objectClick', mapObject)
                }
            }
        })

        container.addChild(bounds)
    }

    pixiRoot.addChild(container)
    mapObjects.set(mapObject.id, container)
}

function pixiUpdateRootTransform() {
    viewZoom = Math.min(Math.max(viewZoom, MIN_ZOOM), MAX_ZOOM)

    pixiRoot.scale = new Point(viewZoom, viewZoom)
    pixiRoot.x = -viewPosX * viewZoom + pixiApp.screen.width * 0.5
    pixiRoot.y = -viewPosY * viewZoom + pixiApp.screen.height * 0.5
}

function pixiFocusOnBounds(bounds: Rectangle) {
    viewPosX += (bounds.x - (pixiApp.screen.width - bounds.width) * 0.5) / viewZoom
    viewPosY += (bounds.y - (pixiApp.screen.height - bounds.height) * 0.5) / viewZoom
    pixiUpdateRootTransform()
}

function pixiSelectObject(id: number | null) {
    if (selectedObjectId !== null) {
        let obj = mapObjects.get(selectedObjectId)
        if (obj !== undefined && obj.filters !== null) {
            obj.filters = OBJECT_FILTERS
        }
    }

    if (id !== null) {
        let obj = mapObjects.get(id)
        if (obj !== undefined) {
            obj.filters = SELECTED_OBJECT_FILTERS
        }
    }

    selectedObjectId = id
}

function pixiUpdate(delta: number) {

}

defineExpose({ getZoom, setZoom })

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
    pixiSelectObject(newId)
})

watch(() => navStore.focusedObjectId, (newId, oldId) => {
    if (newId !== null) {
        focusOnObject(newId)
    }
})

</script>
