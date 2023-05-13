<template>
    <div class="cards-list" ref="viewport">
        <router-link
            v-for="item in items"
            :key="item.id"
            class="unstyled-a"
            :to="linkBuilder(item)"
        >
            <SmallCard :entity="item"/>
        </router-link>
        <SmallCard :entity="null" v-for="i in 3" v-if="hasNext" ref="loadingCards"/>
    </div>
</template>

<style lang="scss">
@import "../scss/style.scss";

.cards-list {
    display: flex;
    flex-direction: column;
    gap: map-get($spacers, 2);
    overflow: auto;
    flex-grow: 1;
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
    maxPage++
    hasNext.value = newItems.length >= defines.FETCH_PAGE_SIZE
}

</script>
