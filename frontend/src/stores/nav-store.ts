import { ref, watch } from "vue";
import { defineStore } from "pinia";
import { MapBuildingSchema, MapDomainSchema } from "../schemas/map-schemas";
import { fetchBuildingById, fetchDomainById, fetchMapObjectById } from "../api/map-api";
import { LocationPoint } from "../schemas/nav-schemas";

export const useNavStore = defineStore('navStore', () => {
    const buildingId = ref<number | null>(1)
    const building = ref<MapBuildingSchema | null>(null)
    const floor = ref<string>('')
    const domain = ref<MapDomainSchema | null>(null)
    const focusedObjectId = ref<number | null>(null)
    const selectedObjectId = ref<number | null>(null)

    const location = ref<LocationPoint | null>(null)
    const isSelectingLocation = ref<boolean>(false)

    watch(buildingId, async (newId, oldId) => {
        if (newId == null) {
            building.value = null
            return
        }

        try {
            building.value = await fetchBuildingById(newId)
            floor.value = Object.keys(building.value.domainIds)[0] ?? ''
        } catch {
            building.value = null
        }
    }, { immediate: true })

    watch(building, (newBuilding, oldBuilding) => {
        buildingId.value = newBuilding?.id ?? null
    })

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

    watch(focusedObjectId, async (newId, oldId) => {
        selectedObjectId.value = newId

        if (newId === null) {
            return
        }

        try {
            let mapObject = await fetchMapObjectById(newId)
            if (building.value?.id !== mapObject.mapBuildingId) {
                building.value = await fetchBuildingById(mapObject.mapBuildingId)
            }
            
            let floors = Object.entries(building.value.domainIds)
            for (let i = 0; i < floors.length; ++i) {
                if (floors[i][1] === mapObject.id) {
                    floor.value = floors[i][0]
                    break
                }
            }
        } catch {
            building.value = null
            floor.value = ''
        }
    })

    return {
        buildingId, building, floor, domain, selectedObjectId, focusedObjectId,
        location, isSelectingLocation
    }
})
