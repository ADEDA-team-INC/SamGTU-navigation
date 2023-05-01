<template>
    <div class="d-flex flex-wrap justify-content-around gap-4">
        <router-link to="/buildings">
            <IconButton
                icon-class="bi-building-fill"
                :subtitle="$t('main_page.buildings')"
            />
        </router-link>
        <router-link to="/outdoor_objects?type=SHOP">
            <IconButton
                icon-class="bi-basket2-fill"
                :subtitle="$t('main_page.shops')"
            />
        </router-link>
        <router-link to="/outdoor_objects?type=CAFE">
            <IconButton
                icon-class="bi-cup-hot-fill"
                :subtitle="$t('main_page.cafes')"
            />
        </router-link>
        <router-link to="/outdoor_objects?type=SIGHT">
            <IconButton
                icon-class="bi-bank2"
                :subtitle="$t('main_page.sights')"
            />
        </router-link>
    </div>
</template>

<style scoped lang="scss">
@import "../../scss/style.scss";

a {
    @extend .unstyled-a;
}
</style>

<script setup lang="ts">
import IconButton from '../../components/IconButton.vue';
</script>
