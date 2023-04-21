<template>
    <div class="small-card" v-if="info !== null">
        <img :src="info.images[0] ?? ''" class="thumbnail" />
        <div class="flex-grow-1">
            <h4>{{ info.displayName  }}</h4>
            <span>{{ info.displayDescription }}</span>
        </div>
    </div>
    <div class="small-card placeholder-glow" v-else>
        <div class="thumbnail placeholder"></div>
        <div class="flex-grow-1">
            <h4 class="placeholder"></h4>
            <span class="placeholder"></span>
        </div>
    </div>
</template>

<style scoped lang="scss">
@import "../scss/style.scss";

.small-card {
    display: flex;
    align-items: center;
    gap: map-get($spacers, 2);
    user-select: none;
    cursor: pointer;

    .thumbnail {
        display: inline-block;
        width: $thumbnail-width;
        height: $thumbnail-height;
        background-size: contain;
        background-position: center;
        background-repeat: no-repeat;
        border-radius: $border-radius;
    }

    h4, span {
        white-space: normal;
        word-wrap: break-word;
        word-break: break-word;
        display: block;
    }
}
</style>

<script setup lang="ts">
import { InfoSchema } from '../schemas/map-schemas';

const props = defineProps<{
    info: InfoSchema | null
}>()
</script>
