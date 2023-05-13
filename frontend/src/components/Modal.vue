<template>
    <div class="modal fade" ref="modal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <slot name="header">
                        <h5 class="modal-title">{{ title }}</h5>
                    </slot>
                    <button
                        type="button"
                        class="btn-close"
                        data-bs-dismiss="modal"
                        @click="() => emit('close')"
                        v-if="closeButton !== undefined"
                    ></button>
                </div>
                <div class="modal-body">
                    <slot></slot>
                </div>
                <div class="modal-footer">
                    <button
                        type="button"
                        class="btn btn-secondary"
                        data-bs-dismiss="modal"
                        @click="() => emit('close')"
                        v-if="closeButton"
                    >
                        {{  closeButton  }}
                    </button>
                    <button
                        type="button"
                        class="btn btn-primary"
                        @click="() => {
                            bootstrapModal?.hide()
                            emit('submit')
                        }"
                    >
                        {{ submitButton }}
                    </button>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup lang="ts">
import { Modal } from 'bootstrap'
import { onMounted, onUnmounted, ref } from 'vue'

const props = defineProps<{
    title?: string,
    closeButton?: string,
    submitButton: string
}>()

const emit = defineEmits<{
    (e: 'submit'): void,
    (e: 'close'): void
}>()

const modal = ref<HTMLElement | null>(null)

let bootstrapModal: Modal | null = null

onMounted(() => {
    if (modal.value == null) {
        return
    }

    bootstrapModal = new Modal(modal.value)
})

onUnmounted(() => {
    if (bootstrapModal !== null) {
        bootstrapModal.dispose()
    }
})

</script>
