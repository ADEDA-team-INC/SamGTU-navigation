<template>
    <Modal
        :title="$t('lang_modal.title')"
        :close-button="$t('modal.close')"
        :submit-button="$t('modal.save')"
        @submit="() => setI18nLanguage(i18n, activeLocale)"
    >
        <div class="list-group">
            <button
                class="list-group-item"
                :class="{ active: lang === activeLocale }"
                @click="() => activeLocale = lang"
                v-for="lang in SUPPORTED_LOCALES"
            >
                {{ $t(`languages.${lang}`) }}
            </button>
        </div>
    </Modal>
</template>

<script setup lang="ts">
import { ref } from 'vue';
import { SUPPORTED_LOCALES, i18n, setI18nLanguage } from '../i18n';
import Modal from './Modal.vue';

const activeLocale = ref<string>(i18n.global.locale.value)

</script>
