<template>
    <Card :entity="building">
        <div>
            <h4>Показать</h4>
            <div class="d-flex justify-content-between">
                <button type="button" class="btn btn-primary">
                    <i class="bi bi-map-fill"></i>
                    На карте
                </button>
                <a :href="mapsLink" class="btn btn-primary" v-if="mapsLink !== null">
                    <i class="bi bi-geo-alt-fill"></i>
                    На Яндекс Картах
                </a>
            </div>
        </div>
        <div v-if="building !== null">
            <h4>Этажи</h4>
            <div class="btn-group">
                <button type="button" class="btn btn-primary" v-for="floor in Object.keys(building.domainIds ?? {})">
                    {{ floor }}
                </button>
            </div>
        </div>
    </Card>
</template>

<script setup lang="ts">
import { useRoute } from 'vue-router';
import Card from '../../components/Card.vue';
import { onMounted, ref, watch } from 'vue';
import { fetchBuildingById } from '../../api/map-api';
import { getYandexMapsLink } from '../../api/thirdparty-api'
import { MapBuildingSchema } from '../../schemas/map-schemas';

const building = ref<MapBuildingSchema | null>(null)
const mapsLink = ref<string | null>(null)
const route = useRoute()

watch(route, async () => {
    if (typeof route.params.id !== 'string') {
        return
    }

    building.value = await fetchBuildingById(Number.parseInt(route.params.id))
    mapsLink.value = getYandexMapsLink(
        building.value.latitude, building.value.longitude, 18
    )
}, { immediate: true })

</script>
