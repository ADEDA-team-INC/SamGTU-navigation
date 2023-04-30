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
import { computed, onMounted, ref, watch } from 'vue';
import {
    Application, Container, Sprite, Graphics,
    Point, ISVGResourceOptions, MIPMAP_MODES, Rectangle
} from 'pixi.js';
import { MapDomainSchema, MapObjectSchema } from '../schemas/map-schemas';

const ZOOM_STEP = 1 / 500
const MIN_ZOOM = 0.8
const MAX_ZOOM = 5
const SVG_PIXELS_PER_METER = 4
const OBJECT_CLICK_DELAY = 100

const props = defineProps<{
    domains: MapDomainSchema[]
}>()

function getZoom() {
    return viewZoom
}
function setZoom(value: number) {
    viewZoom = value
    pixiUpdateRootTransform()
}

const emit = defineEmits<{
    (e: 'objectClick', mapObject: MapObjectSchema): void
}>()

const pixiApp = new Application({
    background: 0xFFFFFF
})
const pixiRoot = new Container()

let viewPosX = 0.0
let viewPosY = 0.0
let viewZoom = 1.0

const viewport = ref<HTMLElement | null>(null)
const resizeObserver = new ResizeObserver(onResize)

let lastPointerX = 0.0
let lastPointerY = 0.0
let pointerId: number | null = null
let isDragging = false

let objectPointerId: number | null = null
let objectPointerDownTime = 0.0

defineExpose({ getZoom, setZoom })

onMounted(() => {
    if (viewport.value !== null) {
        pixiApp.resizeTo = viewport.value
        
        let canvas = pixiApp.view as HTMLCanvasElement
        canvas.style.position = 'absolute'
        viewport.value.appendChild(canvas)
        resizeObserver.observe(canvas)
    }

    recreatePixiObjects()
    pixiUpdateRootTransform()
    pixiApp.stage.addChild(pixiRoot)
    pixiApp.ticker.add(pixiUpdate)
})

watch(props.domains, () => {
    recreatePixiObjects()
})

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

function recreatePixiObjects() {
    for (let i = 0; i < pixiRoot.children.length; ++i) {
        pixiRoot.children[i].destroy()
    }

    for (let i = 0; i < props.domains.length; ++i) {
        let domain = props.domains[i]
        pixiAddDomain(props.domains[i])
        
        for (let j = 0; j < domain.mapObjects.length; ++j) {
            pixiAddMapObject(domain.mapObjects[j])
        }
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
}

function pixiAddMapObject(mapObject: MapObjectSchema) {
    for (let k = 0; k < mapObject.bboxes.length; k++) {
        let bbox = mapObject.bboxes[k]

        let bounds = new Graphics()
        bounds.eventMode = 'static'
        bounds.hitArea = new Rectangle(bbox.positionX, bbox.positionY, bbox.width, bbox.height)
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
                    emit('objectClick', mapObject)
                }
            }
        })

        pixiRoot.addChild(bounds)
    }
}

function pixiUpdateRootTransform() {
    viewZoom = Math.min(Math.max(viewZoom, MIN_ZOOM), MAX_ZOOM)

    pixiRoot.scale = new Point(viewZoom, viewZoom)
    pixiRoot.x = -viewPosX * viewZoom + pixiApp.screen.width * 0.5
    pixiRoot.y = -viewPosY * viewZoom + pixiApp.screen.height * 0.5
}

function pixiUpdate(delta: number) {

}

</script>
