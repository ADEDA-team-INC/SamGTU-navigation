<template>
    <Card :entity="outdoorObject">
        <div>
            <h4>Показать</h4>
            <a :href="mapsLink" class="btn btn-primary" v-if="mapsLink !== null">
                <i class="bi bi-geo-alt-fill"></i>
                На Яндекс Картах
            </a>
        </div>
    </Card>
</template>

<script setup lang="ts">
import { useRoute } from 'vue-router';
import Card from '../../components/Card.vue';
import { ref, watchEffect } from 'vue';
import { fetchOutdoorObjectById } from '../../api/map-api';
import { getYandexMapsLink } from '../../api/thirdparty-api';
import { OutdoorObjectSchema } from '../../schemas/map-schemas';

const outdoorObject = ref<OutdoorObjectSchema | null>(null)
const mapsLink = ref<string | null>(null)
const route = useRoute()

watchEffect(async () => {
    if (typeof route.params.id !== 'string') {
        return
    }

    outdoorObject.value = null
    outdoorObject.value = await fetchOutdoorObjectById(Number.parseInt(route.params.id))
    mapsLink.value = getYandexMapsLink(
        outdoorObject.value.latitude, outdoorObject.value.longitude, 18
    )
})

</script>
