import { defineStore } from "pinia";
import { computed, ref, watchEffect } from "vue";
import defines from "../defines";
import { i18n, setI18nLanguage } from "../i18n";

export const useUserStore = defineStore('userStore', () => {
    const cachedLocale = ref<string | null>(null)
    let locale = computed({
        get() {
            if (cachedLocale.value === null) {
                cachedLocale.value = localStorage.getItem(
                    defines.LOCAL_STORAGE_KEYS.USER_LOCALE
                ) ?? navigator.language
            }
            return cachedLocale.value
        },
        set(value) {
            localStorage.setItem(defines.LOCAL_STORAGE_KEYS.USER_LOCALE, value)
            cachedLocale.value = value
        }
    })

    watchEffect(async () => {
        await setI18nLanguage(i18n, locale.value)
    })

    return { locale }
})
