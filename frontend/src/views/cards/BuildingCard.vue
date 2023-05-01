<template>
    <Card :entity="building">
        <div>
            <h4>{{ $t('map_entity.show') }}</h4>
            <div class="d-flex justify-content-between">
                <button
                    type="button"
                    class="btn btn-primary"
                    @click="() => {
                        if (building !== null) {
                            navStore.buildingId = building.id
                        }
                    }"
                >
                    <i class="bi bi-map-fill"></i>
                    {{ $t('map_entity.on_map') }} 
                </button>
                <a :href="mapsLink" class="btn btn-primary" v-if="mapsLink !== null">
                    <i class="bi bi-geo-alt-fill"></i>
                    {{ $t('map_entity.on_yandex') }}
                </a>
            </div>
        </div>
        <div v-if="building !== null">
            <h4>{{ $t('map_building.floors') }}</h4>
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
import { ref, watchEffect } from 'vue';
import { fetchBuildingById } from '../../api/map-api';
import { getYandexMapsLink } from '../../api/thirdparty-api'
import { MapBuildingSchema } from '../../schemas/map-schemas';
import { useNavStore } from '../../stores/nav-store';

const route = useRoute()
const navStore = useNavStore()

const building = ref<MapBuildingSchema | null>(null)
const mapsLink = ref<string | null>(null)

watchEffect(async () => {
    if (typeof route.params.id !== 'string') {
        return
    }

    building.value = null
    building.value = await fetchBuildingById(Number.parseInt(route.params.id))
    mapsLink.value = getYandexMapsLink(
        building.value.latitude, building.value.longitude, 18
    )
})

</script>
