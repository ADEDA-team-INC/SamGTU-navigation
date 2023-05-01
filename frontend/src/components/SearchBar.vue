<template>
    <form class="d-flex gap-2" @submit.prevent="onSearchClick">
        <input
            class="form-control"
            type="text"
            :placeholder="$t('search')"
            ref="searchInput"
        >
        <button type="submit" class="btn btn-primary">
            <i class="bi bi-search"></i>
        </button>
        <button
            type="button"
            class="btn btn-primary"
            v-if="router.currentRoute.value.name !== 'main'"
            @click="() => router.push({name: 'main'})"
        >
            <i class="bi bi-house-door"></i>
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
    if (searchInput.value === null ||
        searchInput.value.value.trim().length == 0
    ) {
        return
    }

    router.push({
        name: 'search',
        query: { query: searchInput.value.value.trim() }
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
