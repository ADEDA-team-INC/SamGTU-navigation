import { I18n, createI18n } from 'vue-i18n'
import { useUserStore } from './stores/user-store'
import { getLanguageCode } from './utils/locale'

export const SUPPORTED_LOCALES = ['ru', 'en']
export const DEFAULT_LOCALE = 'ru' 

export function setupI18n() {
    const i18n = createI18n({
        availableLocales: SUPPORTED_LOCALES,
        locale: DEFAULT_LOCALE,
        fallbackLocale: DEFAULT_LOCALE,
        legacy: false
    })
    
    return i18n
}

export async function setI18nLanguage(locale: string) {
    const message = await import(`./locales/${getLanguageCode(locale)}.json`)

    i18n.global.setLocaleMessage(locale, message.default)
    i18n.global.locale.value = locale

    useUserStore().locale = locale

    document.querySelector('html')?.setAttribute('lang', locale)
}

export const i18n = setupI18n()
