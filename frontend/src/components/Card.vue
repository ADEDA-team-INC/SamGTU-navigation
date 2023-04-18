<template>
    <div v-if="entity !== null">
        <div class="card-carousel carousel slide" ref="carouselElem">
            <div class="carousel-inner">
                <div
                    class="carousel-item"
                    :class="{ active: index == 0 }"
                    v-for="(image, index) in entity.info.images"
                >
                    <div
                        class="carousel-image"
                        :style="{
                            backgroundImage: `url(${image})`
                        }"
                    ></div>
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target=".card-carousel" data-bs-slide="prev">
                <span class="carousel-control-prev-icon"></span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target=".card-carousel" data-bs-slide="next">
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

.carousel-image {
    display: block;
    width: 100%;
    min-height: 150px;
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    background-color: rgba($loading-color, 0.5);
    border-radius: $border-radius;
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
