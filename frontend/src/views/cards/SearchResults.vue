<template>
    <div class="cards-list" v-if="searchResult === null">
        <SmallCard :entity="null" v-for="i in 3"/>
    </div>
    <div class="cards-list"
        v-else-if="
            searchResult.mapBuildings.length === 0 &&
            searchResult.mapObjects.length === 0 &&
            searchResult.outdoorObjects.length === 0
        "
    >
        <h4 class="text-center">{{ $t('searching.empty') }}</h4>
    </div>
    <div class="cards-list" v-else>
        <h4>{{ $t('searching.results') }}</h4>
        
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
import { MapEntity, MapSearchResult } from '../../schemas/map-schemas';
import { search } from '../../api/map-api';
import { ref, watchEffect } from 'vue';
import SmallCard from '../../components/SmallCard.vue';

const route = useRoute()

const searchResult = ref<MapSearchResult | null>(null)

watchEffect(async () => {
    let searchQuery = ''
    if (typeof route.query['query'] === 'string') {
        searchQuery = route.query.query
    }
    searchResult.value = null
    searchResult.value = await search(searchQuery)
})

</script>
