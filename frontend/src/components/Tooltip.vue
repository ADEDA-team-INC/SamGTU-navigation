<template></template>

<script setup lang="ts">
import { Tooltip } from 'bootstrap';
import { nextTick, onMounted, onUnmounted, ref, watch } from 'vue';

const props = defineProps<{
    target: string | Element,
    title: string
}>()

const tooltip = ref<Tooltip | null>()

onMounted(() => {
    nextTick(() => {
        tooltip.value = new Tooltip(props.target, {
            title: props.title
        })
    })
})

onUnmounted(() => {
    tooltip.value?.dispose()
})

watch(() => props.title, (newTitle, oldTitle) => {
    tooltip.value?.dispose()
    tooltip.value = new Tooltip(props.target, {
        title: newTitle
    })
})

</script>
