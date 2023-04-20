<template>
    <div class="d-flex flex-wrap justify-content-around gap-4">
        <router-link class="unstyled-a" to="/buildings">
            <IconButton icon-class="bi-building-fill" subtitle="Корпуса" />
        </router-link>
        <IconButton icon-class="bi-basket2-fill" subtitle="Магазины" />
        <IconButton icon-class="bi-cup-hot-fill" subtitle="Кафе" />
    </div>
</template>

<script setup lang="ts">
import IconButton from '../../components/IconButton.vue';
</script>
