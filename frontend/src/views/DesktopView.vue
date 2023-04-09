<template>
    <div class="vw-100 vh-100 d-flex">
        <aside class="border-end bg-light d-flex flex-column p-4">
            <SearchBar />
            <hr class="my-4">
            <router-view />
        </aside>
        <main class="flex-grow-1">

        </main>
    </div>
</template>

<style scoped lang="scss">
@import "../scss/defines";

aside {
    width: $sidebar-width;
}
</style>

<script setup lang="ts">
import SearchBar from '../components/SearchBar.vue'
</script>
