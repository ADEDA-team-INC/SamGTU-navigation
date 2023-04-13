<template>
    <div class="icon-button">
        <i :class="['d-block fs-4 bi', props.iconClass]"></i>
        <span>{{ props.subtitle }}</span>
    </div>
</template>

<style scoped lang="scss">
@import "../scss/defines";

.icon-button {
    min-width: $icon-button-min-width;
    display: inline-block;
    text-align: center;
    text-decoration: none;
    user-select: none;
    cursor: pointer;
}
</style>

<script setup lang="ts">
const props = defineProps<{
    subtitle: string,
    iconClass: string
}>()
</script>
