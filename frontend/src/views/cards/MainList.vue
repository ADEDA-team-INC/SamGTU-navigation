<template>
    <div class="d-flex flex-wrap justify-content-around gap-4">
        <router-link class="unstyled-a" to="/buildings">
            <IconButton icon-class="bi-building-fill" subtitle="Корпуса" />
        </router-link>
        <router-link class="unstyled-a" to="/outdoor_objects?type=SHOP">
            <IconButton icon-class="bi-basket2-fill" subtitle="Магазины" />
        </router-link>
        <router-link class="unstyled-a" to="/outdoor_objects?type=CAFE">
            <IconButton icon-class="bi-cup-hot-fill" subtitle="Кафе" />
        </router-link>
        <router-link class="unstyled-a" to="/outdoor_objects?type=SIGHT">
            <IconButton icon-class="bi-bank2" subtitle="Места" />
        </router-link>
    </div>
</template>

<script setup lang="ts">
import IconButton from '../../components/IconButton.vue';
</script>
