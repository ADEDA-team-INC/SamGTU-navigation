<template>
    <h4>Результаты поиска</h4>
    <div class="cards-list" v-if="searchResult === null">
        <SmallCard :entity="null" v-for="i in 3"/>
    </div>
    <div class="cards-list" v-else>
        <router-link
            v-for="building in searchResult?.mapBuildings"
            :key="building.id"
            class="unstyled-a"
            :to="`building/${building.id}`"
        >
            <SmallCard :entity="building"/>
        </router-link>

        <router-link
            v-for="mapObject in searchResult?.mapObjects"
            :key="mapObject.id"
            class="unstyled-a"
            :to="`object/${mapObject.id}`"
        >
            <SmallCard :entity="mapObject"/>
        </router-link>

        <router-link
            v-for="outdoorObject in searchResult?.outdoorObjects"
            :key="outdoorObject.id"
            class="unstyled-a"
            :to="`outdoor_object/${outdoorObject.id}`"
        >
            <SmallCard :entity="outdoorObject"/>
        </router-link>
    </div>
</template>

<script setup lang="ts">
import { useRoute } from 'vue-router';
import { MapSearchResult } from '../../schemas/map-schemas';
import { search } from '../../api/map-api';
import { onMounted, ref, watch } from 'vue';
import SmallCard from '../../components/SmallCard.vue';

const route = useRoute()

let searchResult = ref<MapSearchResult | null>(null)

onMounted(async () => {
    watch(route, async () => {
        let searchQuery = ''
        if (typeof route.query['query'] === 'string') {
            searchQuery = route.query.query
        }
        searchResult.value = await search(searchQuery)
    }, { immediate: true })
})

</script>
