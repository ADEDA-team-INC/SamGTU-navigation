<template>
    <div v-if="entity !== null">
        <div class="card-carousel carousel slide" ref="carouselElem">
            <div class="carousel-inner">
                <div
                    class="carousel-item"
                    :class="{ active: index == 0 }"
                    v-for="(image, index) in entity.info.images"
                >
                    <img :src="image" class="carousel-image" />
                </div>
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
        <div class="carousel-image placeholder"></div>
        <h2 class="w-100 placeholder mt-2"></h2>
        <span class="w-100 placeholder"></span>
    </div>
</template>

<style scoped lang="scss">
@import "../scss/style.scss";

.carousel-item {
    width: 100%;
    height: 150px;
    background-color: rgba($loading-color, 0.5);
    border-radius: $border-radius;
    overflow: hidden;

    img {
        width: 100%;
        height: 100%;
        object-fit: cover;
    }
}
</style>

<script setup lang="ts">
import Carousel from 'bootstrap/js/dist/carousel'
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
