<template>
    <DesktopView />
</template>

<script setup lang="ts">
import { useRouter } from 'vue-router'
import { useI18n } from 'vue-i18n'
import DesktopView from './views/DesktopView.vue'
import { ref, watchEffect } from 'vue'

const DEFAULT_TITLE_KEY = 'main_page.title'

const router = useRouter()
const i18n = useI18n()

const titleKey = ref<string>(DEFAULT_TITLE_KEY)

router.afterEach((to, from) => {
    if (typeof(to.meta.titleKey) === 'string') {
        titleKey.value = to.meta.titleKey
    } else {
        titleKey.value = DEFAULT_TITLE_KEY
    }
})

watchEffect(() => {
    document.title = i18n.t(titleKey.value)
})

</script>
