<template>
    <Card :entity="mapObject">
        <div>
            <h4>Показать</h4>
            <div class="d-flex justify-content-between">
                <button
                    type="button"
                    class="btn btn-primary"
                    @click="() =>
                        navStore.focusedObjectId = mapObject?.id ?? null
                    "
                >
                    <i class="bi bi-map-fill"></i> На карте
                </button>
            </div>
        </div>
    </Card>
</template>

<script setup lang="ts">
import { onBeforeRouteLeave, useRoute } from 'vue-router';
import Card from '../../components/Card.vue';
import { ref, watchEffect } from 'vue';
import { fetchMapObjectById } from '../../api/map-api';
import {  DetailedMapObject } from '../../schemas/map-schemas';
import { useNavStore } from '../../stores/nav-store';

const navStore = useNavStore()

const mapObject = ref<DetailedMapObject | null>(null)
const route = useRoute()

watchEffect(async () => {
    if (typeof route.params.id !== 'string') {
        return
    }
    
    mapObject.value = null
    mapObject.value = await fetchMapObjectById(Number.parseInt(route.params.id))
    navStore.selectedObjectId = mapObject.value.id
})

onBeforeRouteLeave((to, from, next) => {
    if (navStore.selectedObjectId === mapObject.value?.id) {
        navStore.selectedObjectId = null
    }
    next()
})

</script>
