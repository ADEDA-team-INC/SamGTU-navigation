<template>
    <Card :entity="building"/>
</template>

<style scoped lang="scss">
</style>

<script setup lang="ts">
import { useRoute } from 'vue-router';
import Card from '../../components/Card.vue';
import { onMounted, ref } from 'vue';
import { fetchBuildingById } from '../../api/map-api';
import { MapBuildingSchema } from '../../schemas/map-schemas';

const building = ref<MapBuildingSchema | null>(null)
const route = useRoute()

onMounted(async () => {
    if (typeof route.params.id !== 'string') {
        return
    }

    building.value = await fetchBuildingById(Number.parseInt(route.params.id))
})

</script>
