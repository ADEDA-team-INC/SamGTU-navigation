<template>
    <div class="vw-100 vh-100 d-flex">
        <aside class="d-flex flex-column p-4 border-end bg-light shadow-sm">
            <SearchBar />
            <hr class="my-4">
            <router-view />
        </aside>
        <MapViewport class="flex-grow-1" />
    </div>
</template>

<style scoped lang="scss">
@import "../scss/style";

aside {
    width: $sidebar-width;
}
</style>

<script setup lang="ts">
import MapViewport from '../components/MapViewport.vue';
import SearchBar from '../components/SearchBar.vue'
</script>
