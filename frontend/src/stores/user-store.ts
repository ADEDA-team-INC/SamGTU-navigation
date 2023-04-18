import { defineStore } from "pinia";
import { computed } from "vue";

export const useUserStore = defineStore('userStore', () => {
    let language = computed(() => {
        return window.navigator.language
    })

    return { language }
})
