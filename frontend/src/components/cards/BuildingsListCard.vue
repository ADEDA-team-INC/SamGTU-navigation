<template>
    <ul class="list-unstyled">
        <li v-for="building in buildings" :key="building.id">
            <SmallCard
                thumbnail-url="https://avatars.mds.yandex.net/get-altay/1433431/2a00000185e6ddc443acf6240f45696f296e/XXXL"
                :title="building.displayName"
                :description="building.displayDescription"
            />
        </li>
    </ul>
</template>

<style scoped lang="scss">
@import "../../scss/style";

li:not(:first-child) {
    margin-top: map-get($spacers, 2);
}
</style>

<script setup lang="ts">
import { onMounted } from 'vue';
import SmallCard from '../SmallCard.vue'
import { useBuildingsStore } from '../../stores/map-store';

const buildingsStore = useBuildingsStore()

const buildings = buildingsStore.buildings

onMounted(async () => {
    if (buildingsStore.buildings.length == 0) {
        await buildingsStore.fetchNext()
    }
})

</script>
