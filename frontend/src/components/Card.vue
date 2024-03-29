<template>
    <div v-if="entity !== null">
        <div class="card-carousel carousel slide" ref="carouselElem">
            <div class="carousel-inner">
                <div
                    class="carousel-item image-container"
                    :class="{ active: index == 0 }"
                    v-for="(image, index) in entity.info.images"
                >
                    <img :src="image" />
                </div>
                <div
                    class="carousel-item image-container active"
                    v-if="entity.info.images.length === 0"
                ></div>
            </div>
            <button
                class="carousel-control-prev"
                type="button"
                data-bs-target=".card-carousel"
                data-bs-slide="prev"
                v-if="entity.info.images.length > 1"
            >
                <span class="carousel-control-prev-icon"></span>
            </button>
            <button
                class="carousel-control-next"
                type="button"
                data-bs-target=".card-carousel"
                data-bs-slide="next"
                v-if="entity.info.images.length > 1"
            >
                <span class="carousel-control-next-icon"></span>
            </button>
        </div>
        <h2 class="text-break mt-2">{{ entity.info.displayName }}</h2>
        <span class="d-block text-break">
            {{ entity.info.displayDescription }}
        </span>
    </div>
    <div class="placeholder-glow" v-else>
        <div class="image-container placeholder"></div>
        <h2 class="w-100 placeholder mt-2"></h2>
        <span class="w-100 placeholder"></span>
    </div>
    <div class="flex-grow-1 d-flex flex-column gap-4 mt-4">
        <slot></slot>
    </div>
</template>

<style scoped lang="scss">
@import "../scss/style.scss";

.image-container {
    width: 100%;
    height: 150px;
    background-color: rgba($loading-color, 0.5);
    border-radius: $border-radius;
    overflow: hidden;
    opacity: 1;

    img {
        width: 100%;
        height: 100%;
        object-fit: cover;
    }
}
</style>

<script setup lang="ts">
import { Carousel } from 'bootstrap';
import { MapEntity } from '../schemas/map-schemas';
import { onMounted, ref } from 'vue';

const props = defineProps<{
    entity: MapEntity | null
}>()
const carouselElem = ref<HTMLElement | null>(null)

onMounted(() => {
    if (carouselElem.value !== null) {
        let carousel = new Carousel(carouselElem.value)
    }
})
</script>
