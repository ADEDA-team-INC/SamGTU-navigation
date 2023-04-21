<template>
    <Card :entity="outdoorObject"/>
</template>

<style scoped lang="scss">
</style>

<script setup lang="ts">
import { useRoute } from 'vue-router';
import Card from '../../components/Card.vue';
import { onMounted, ref } from 'vue';
import { fetchOutdoorObjectById } from '../../api/map-api';
import { OutdoorObjectSchema } from '../../schemas/map-schemas';

const outdoorObject = ref<OutdoorObjectSchema | null>(null)
const route = useRoute()

onMounted(async () => {
    if (typeof route.params.id !== 'string') {
        return
    }

    outdoorObject.value = await fetchOutdoorObjectById(Number.parseInt(route.params.id))
})

</script>
