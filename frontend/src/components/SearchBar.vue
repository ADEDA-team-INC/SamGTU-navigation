<template>
    <form class="d-flex gap-2" @submit.prevent="onSearchClick">
        <input class="form-control" type="text" placeholder="Поиск" ref="searchInput">
        <button type="submit" class="btn btn-primary">
            <i class="bi bi-search"></i>
        </button>
    </form>
</template>

<style scoped lang="scss">
</style>

<script setup lang="ts">
import { onMounted, ref, watch } from 'vue';
import { useRoute, useRouter } from 'vue-router';

const route = useRoute()
const router = useRouter()

let searchInput = ref<HTMLInputElement | null>(null)

function onSearchClick() {
    router.push({
        name: 'search',
        query: { query: searchInput.value?.value }
    })
}

onMounted(() => {
    watch(route, () => {
        let searchQuery = ''
        if (typeof route.query['query'] === 'string') {
            searchQuery = route.query.query
        }
        if (searchInput.value !== null) {
            searchInput.value.value = searchQuery
        }
    }, { immediate: true })
})

</script>
