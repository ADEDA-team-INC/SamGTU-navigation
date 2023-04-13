import { defineStore } from 'pinia'
import { ref, reactive } from 'vue'
import { MapBuildingSchema, MapDomainSchema, MapObjectSchema } from '../schemas/map-schemas'
import { fetchBuildingById, fetchBuildings, fetchDomainById } from '../utils/rest-api'
import defines from '../defines'

export const useBuildingsStore = defineStore('buildings', () => {
    const buildings = reactive(new Array<MapBuildingSchema>())
    const buildingsMap = reactive(new Map<number, MapBuildingSchema>())
    const maxPage = ref(0)
    const hasNext = ref(true)

    async function fetchById(id: number) {
        if (!buildingsMap.has(id)) {
            let building = await fetchBuildingById(id)
            if (building === undefined) {
                return null
            }
            buildingsMap.set(id, building)
        }
        return buildingsMap.get(id) as MapBuildingSchema
    }

    async function fetchNext() {
        if (!hasNext.value) {
            return
        }

        let result = await fetchBuildings(maxPage.value)
        if (result.length < defines.FETCH_PAGE_SIZE) {
            hasNext.value = false
        } else {
            maxPage.value++
        }

        result.forEach((building) => {
            let buildingRef = buildingsMap.get(building.id)
            if (buildingRef !== undefined) {
                buildings.push(buildingRef)
            } else {
                buildingsMap.set(building.id, building)
                buildings.push(building)
            }
        })
    }

    return { buildings, fetchById, fetchNext, hasNext }
})

export const useDomainsStore = defineStore('domains', () => {
    const domainsMap = reactive(new Map<number, MapDomainSchema>())

    const mapObjectsStore = useMapObjectsStore()

    async function fetchById(id: number) {
        if (!domainsMap.has(id)) {
            let domain = await fetchDomainById(id)
            if (domain === undefined) {
                return null
            }
            domainsMap.set(id, domain)
            mapObjectsStore.addObjectsFromDomain(domain)
        }
        return domainsMap.get(id) as MapDomainSchema
    }

    return { fetchById }
})

export const useMapObjectsStore = defineStore('mapObjects', () => {
    const mapObjectsMap = reactive(new Map<number, MapObjectSchema>())

    async function fetchById(id: number) {
        return mapObjectsMap.get(id) ?? null
    } 

    function addObjectsFromDomain(domain: MapDomainSchema) {
        domain.mapObjects.forEach((mapObject) => {
            if (!mapObjectsMap.has(mapObject.id)) {
                mapObjectsMap.set(mapObject.id, mapObject)
            }
        })
    }

    return { fetchById, addObjectsFromDomain }
})
