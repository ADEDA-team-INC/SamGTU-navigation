<template>
    <h4>Результаты поиска</h4>
    <div v-if="searchResult === null">
        <
    </div>
    <div v-else>
        <Card
            v-for="building in searchResult?.mapBuildings"
            :key="building.id"

        />
    </div>
</template>

<script setup lang="ts">
import { useRoute } from 'vue-router';
import Card from '../../components/Card.vue';
import { MapSearchResult } from '../../schemas/map-schemas';
import { search } from '../../api/map-api';
import { onMounted, ref } from 'vue';

const route = useRoute()

let searchQuery = ''
if (typeof route.query['query'] === 'string') {
    searchQuery = route.query.query
}

let searchResult = ref<MapSearchResult | null>(null)

onMounted(async () => {
    searchResult.value = await search(searchQuery)
})

</script>
