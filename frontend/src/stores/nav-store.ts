import { ref, watch } from "vue";
import { defineStore } from "pinia";
import { MapBuildingSchema, MapDomainSchema } from "../schemas/map-schemas";
import { fetchBuildingById, fetchDomainById } from "../api/map-api";

export const useNavStore = defineStore('navStore', () => {
    const buildingId = ref<number>(1)
    const building = ref<MapBuildingSchema | null>(null)
    const floor = ref<string>('')
    const domain = ref<MapDomainSchema | null>(null)

    watch(buildingId, async (newId, oldId) => {
        try {
            building.value = await fetchBuildingById(newId)
            floor.value = Object.keys(building.value.domainIds)[0] ?? ''
        } catch {
            building.value = null
        }
    }, { immediate: true })

    watch(floor, async (newFloor, oldFloor) => {
        if (newFloor.length == 0 ||
            building.value === null ||
            building.value.domainIds[newFloor] === null
        ) {
            domain.value = null
            return
        }

        try {
            domain.value = await fetchDomainById(building.value.domainIds[newFloor])
        } catch {
            domain.value = null
        }
    }, { immediate: true })

    return { buildingId, building, floor, domain }
})
