<template>
    <div class="container">
        <div class="row row-cols-3">
            <router-link class="col" to="/buildings">
                <IconButton
                    icon-class="bi-building-fill"
                    :subtitle="$t('main_page.buildings')"
                />
            </router-link>
            <router-link class="col" to="/outdoor_objects?type=SHOP">
                <IconButton
                    icon-class="bi-basket2-fill"
                    :subtitle="$t('main_page.shops')"
                />
            </router-link>
            <router-link class="col" to="/outdoor_objects?type=CAFE">
                <IconButton
                    icon-class="bi-cup-hot-fill"
                    :subtitle="$t('main_page.cafes')"
                />
            </router-link>
            <router-link class="col" to="/outdoor_objects?type=SIGHT">
                <IconButton
                    icon-class="bi-bank2"
                    :subtitle="$t('main_page.sights')"
                />
            </router-link>
        </div>
    </div>
</template>

<style scoped lang="scss">
@import "../../scss/style.scss";

a {
    @extend .unstyled-a;
}

.col:nth-child(n + 4) {
    margin-top: map-get($spacers, 4);
}
</style>

<script setup lang="ts">
import IconButton from '../../components/IconButton.vue';
</script>
