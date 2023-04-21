<template>
    <ul class="m-0 list-unstyled flex-grow-1 overflow-auto" ref="viewport">
        <li v-for="item in items" :key="item.id">
            <router-link class="unstyled-a" :to="linkBuilder(item)">
                <SmallCard :info="item.info"/>
            </router-link>
        </li>
        <li v-for="i in 3" v-if="hasNext && !isFirstLoaded" ref="loadingCards">
            <SmallCard :info="null"/>
        </li>
    </ul>
</template>

<style scoped lang="scss">
@import "../scss/style";

li:not(:first-child) {
    margin-top: map-get($spacers, 2);
}
</style>

<script setup lang="ts">
import { onMounted, reactive, ref } from 'vue'
import SmallCard from './SmallCard.vue'
import { MapEntity } from '../schemas/map-schemas'
import defines from '../defines'

const props = defineProps<{
    fetcher: (page: number) => Promise<MapEntity[]>,
    linkBuilder: (entity: MapEntity) => string
}>()

let maxPage = 0
const isFirstLoaded = ref(true)
const hasNext = ref(true)
const items: MapEntity[] = reactive([])

const viewport = ref<HTMLElement | null>(null)
const loadingCards = ref<HTMLElement[]>([])
let observer: null | IntersectionObserver = null

onMounted(async () => {
    await getNextPage()

    observer = new IntersectionObserver(() => getNextPage().then(), {
        root: viewport.value,
        threshold: 0.5
    })

    loadingCards.value.forEach((val) => observer?.observe(val))
})

async function getNextPage() {
    if (!hasNext.value) {
        return
    }

    let newItems = await props.fetcher(maxPage)
    newItems.forEach((val) => items.push(val))
    isFirstLoaded.value = false
    maxPage++
    hasNext.value = newItems.length >= defines.FETCH_PAGE_SIZE
}

</script>
