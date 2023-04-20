<template>
    <CardsList
        :fetcher="fetchBuildings"
        :link-builder="item => `/building/${item.id}`"
    />
</template>

<script setup lang="ts">
import { fetchBuildings } from '../../api/map-api';
import CardsList from '../../components/CardsList.vue';

</script>
