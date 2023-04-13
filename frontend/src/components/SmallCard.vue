<template>
    <div class="small-card">
        <div class="thumbnail rounded" :style="{ backgroundImage: `url(${thumbnailUrl})` }"></div>
        <div class="flex-grow-1">
            <h4>{{ title }}</h4>
            <span>{{ description }}</span>
        </div>
    </div>
</template>

<style scoped lang="scss">
@import "../scss/style.scss";
@import "../scss/defines.scss";

.small-card {
    display: flex;
    align-items: center;
    gap: map-get($spacers, 2);
    user-select: none;
    cursor: pointer;
}

.thumbnail {
    width: $thumbnail-width;
    height: $thumbnail-height;
    background-size: contain;
    background-position: center;
}
</style>

<script setup lang="ts">
const props = defineProps<{
    thumbnailUrl?: string
    title: string
    description: string
}>()
</script>
