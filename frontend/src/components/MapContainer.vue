<template>
    <div class="map-container">
        <MapRenderer :domains="domains" @object-click="onObjectClick" />

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
            <div class="btn-group-vertical border rounded shadow-sm">
                <button class="btn btn-light">
                    <i class="bi bi-plus fs-4"></i>
                </button>
                <button class="btn btn-light">
                    <i class="bi bi-dash fs-4"></i>
                </button>
            </div>

            <button class="btn btn-light border shadow-sm">
                <i class="bi bi-qr-code-scan fs-4"></i>
            </button>

            <button class="btn btn-light border shadow-sm">
                <i class="bi bi-pin-map fs-4"></i>
            </button>
        </div>
    </div>
</template>

<style scoped lang="scss">
@import "../scss/style.scss";

.map-container {
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
</style>

<script setup lang="ts">
import { reactive, watch } from 'vue';
import { useNavStore } from '../stores/nav-store';
import MapRenderer from './MapRenderer.vue';
import { MapDomainSchema, MapObjectSchema } from '../schemas/map-schemas';
import { useRouter } from 'vue-router';

const navStore = useNavStore()
const router = useRouter()

const domains = reactive<Array<MapDomainSchema>>([])

navStore.$subscribe((mutation, state) => {
    domains.length = 0
    if (state.domain !== null) {
        domains.push(state.domain)
    }
})

function onObjectClick(mapObject: MapObjectSchema) {
    router.push({ name: 'map_object', params: { id: mapObject.id } })
}

</script>
