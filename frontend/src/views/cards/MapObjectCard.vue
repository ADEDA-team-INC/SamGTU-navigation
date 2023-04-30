<template>
    <Card :entity="mapObject">
        <div>
            <h4>Показать</h4>
            <div class="d-flex justify-content-between">
                <button type="button" class="btn btn-primary">
                    <i class="bi bi-map-fill"></i>
                    На карте
                </button>
            </div>
        </div>
    </Card>
</template>

<script setup lang="ts">
import { useRoute } from 'vue-router';
import Card from '../../components/Card.vue';
import { ref, watch } from 'vue';
import { fetchMapObjectById } from '../../api/map-api';
import {  DetailedMapObject } from '../../schemas/map-schemas';

const mapObject = ref<DetailedMapObject | null>(null)
const route = useRoute()

watch(route, async () => {
    if (typeof route.params.id !== 'string') {
        return
    }

    mapObject.value = await fetchMapObjectById(Number.parseInt(route.params.id))
}, { immediate: true })

</script>
