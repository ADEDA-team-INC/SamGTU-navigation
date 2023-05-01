<template>
    <div class="map-container">
        <MapRenderer @object-click="onObjectClick" ref="renderer" />

        <div class="top-hud-bar">
            <nav>
                <ol class="breadcrumb justify-content-center m-0">
                    <li class="breadcrumb-item">Корпус №9 СамГТУ</li>
                    <li class="breadcrumb-item">1 этаж</li>
                    <li class="breadcrumb-item">Аудитория 100</li>
                </ol>
            </nav>
        </div>

        <div class="side-hud-bar">
            <div
                class="btn-group-vertical border rounded shadow-sm"
                v-if="navStore.building !== null"
            >
                <template v-for="floor in Object.keys(navStore.building.domainIds)">
                    <input
                        type="radio"
                        class="btn-check"
                        name="floor-radio"
                        :id="'floor-radio-' + floor"
                        :checked="navStore.floor == floor"
                    />
                    <label class="btn btn-light" :for="'floor-radio-' + floor">
                        {{ floor }}
                    </label>
                </template>
            </div>
            
            <div class="btn-group-vertical border rounded shadow-sm">
                <button
                    class="btn btn-light"
                    @click="() => {
                        if (renderer !== null) {
                            renderer.setZoom(renderer.getZoom() + BUTTON_ZOOM_STEP)
                        }
                    }"
                >
                    <i class="bi bi-plus fs-4"></i>
                </button>
                <button
                    class="btn btn-light"
                    @click="() => {
                        if (renderer !== null) {
                            renderer.setZoom(renderer.getZoom() - BUTTON_ZOOM_STEP)
                        }
                    }"
                >
                    <i class="bi bi-dash fs-4"></i>
                </button>
            </div>

            <button
                class="btn btn-light border shadow-sm"
                id="scan-qr-btn"
            >
                <i class="bi bi-qr-code-scan fs-4"></i>
            </button>

            <button
                class="btn btn-light border shadow-sm"
                id="select-loc-btn"
            >
                <i class="bi bi-pin-map fs-4"></i>
            </button>
        </div>

        <div class="right-bottom-hud-bar">
            <button
                class="btn btn-light border shadow-sm"
                id="change-lang-btn"
            >
                <i class="bi bi-globe-americas fs-4"></i>
            </button>
        </div>
    </div>

    <Tooltip target="#scan-qr-btn" title="Сканировать QR код"/>
    <Tooltip target="#select-loc-btn" title="Выбрать местоположение"/>
    <Tooltip target="#change-lang-btn" title="Изменить язык"/>
</template>

<style scoped lang="scss">
@import "../scss/style.scss";

.map-container {
    flex-grow: 1;
    position: relative;
}

.top-hud-bar {
    position: absolute;
    top: 0;
    left: 50%;
    transform: translate(-50%, 0);
    background-color: $light;
    margin-top: map-get($spacers, 2);
    padding: map-get($spacers, 2) map-get($spacers, 4);
    border-radius: $border-radius-pill;
    border: $border-width $border-style $border-color;
    box-shadow: $box-shadow-sm;
}

.top-left-hud-bar {
    position: absolute;
    top: 0;
    right: 0;
    margin-top: map-get($spacers, 2);
    margin-right: map-get($spacers, 3);
    border-radius: $border-radius;
    border: $border-width $border-style $border-color;
    box-shadow: $box-shadow-sm;
}

.side-hud-bar {
    position: absolute;
    right: 0;
    top: 50%;
    transform: translate(0, -50%);
    margin-right: map-get($spacers, 3);
    display: flex;
    flex-direction: column;
    row-gap: map-get($spacers, 3);
}

.right-bottom-hud-bar {
    position: absolute;
    right: 0;
    bottom: 0;
    margin-bottom: map-get($spacers, 4);
    margin-right: map-get($spacers, 3);
}
</style>

<script setup lang="ts">
import { ref } from 'vue';
import MapRenderer from './MapRenderer.vue';
import { MapObjectSchema } from '../schemas/map-schemas';
import { useRouter } from 'vue-router';
import { useNavStore } from '../stores/nav-store';
import Tooltip from './Tooltip.vue';

const BUTTON_ZOOM_STEP = 0.6

const navStore = useNavStore()
const router = useRouter()

const renderer = ref<InstanceType<typeof MapRenderer> | null>(null)

function onObjectClick(mapObject: MapObjectSchema) {
    router.push({ name: 'map_object', params: { id: mapObject.id } })
}

</script>
