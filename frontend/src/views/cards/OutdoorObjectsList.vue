<template>
    <CardsList
        :fetcher="page => fetchOutdoorObjects(objectType, page)"
        :link-builder="item => `/outdoor_object/${item.id}`"
    />
</template>

<script setup lang="ts">
import { useRoute } from 'vue-router';
import { fetchOutdoorObjects } from '../../api/map-api';
import CardsList from '../../components/CardsList.vue';
import { OutdoorObjectType } from '../../schemas/map-schemas';

const route = useRoute()

let objectType: OutdoorObjectType | null = null
if (typeof route.query['type'] === 'string') {
    objectType = route.query.type as OutdoorObjectType
}

</script>
