<template>
    <CardsList
        :fetcher="page => fetchOutdoorObjects(objectType, page)"
        :link-builder="item => `/outdoor_object/${item.id}`"
    />
</template>

<script setup lang="ts">
import { ref, watchEffect } from 'vue';
import { useRoute } from 'vue-router';
import { fetchOutdoorObjects } from '../../api/map-api';
import CardsList from '../../components/CardsList.vue';
import { OutdoorObjectType } from '../../schemas/map-schemas';
import { useI18n } from 'vue-i18n';

const TITLES_KEYS = {
    [OutdoorObjectType.Cafe]: 'cafes_list.title',
    [OutdoorObjectType.Shop]: 'shops_list.title',
    [OutdoorObjectType.Sight]: 'sights_list.title'
}

const route = useRoute()
const i18n = useI18n()

let objectType = ref<OutdoorObjectType | null>(null)

watchEffect(() => {
    if (typeof route.query['type'] === 'string') {
        objectType.value = route.query.type as OutdoorObjectType

        document.title = i18n.t(TITLES_KEYS[objectType.value])
    }
})

</script>
