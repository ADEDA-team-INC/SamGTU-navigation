import defines from '../defines'
import { DetailedMapObject, MapBuildingSchema, MapDomainSchema, MapObjectType, MapSearchResult, OutdoorObjectSchema, OutdoorObjectType } from '../schemas/map-schemas'
import apiUtils from '../utils/api-utils'

export async function fetchBuildings(page: number) {
    return await apiUtils.get('map/buildings', {
        size: defines.FETCH_PAGE_SIZE.toString(),
        page: page.toString()
    }) as MapBuildingSchema[]
}

export async function fetchBuildingById(id: number) {
    return await apiUtils.get(`map/building/${id}`, {}) as MapBuildingSchema
}

export async function fetchDomainById(id: number) {
    return await apiUtils.get(`map/domain/${id}`, {}) as MapDomainSchema
}

export async function fetchMapObjectById(id: number) {
    return await apiUtils.get(`map/object/${id}`, {}) as DetailedMapObject
}

export async function fetchOutdoorObjects(type: OutdoorObjectType | null, page: number) {
    return await apiUtils.get('map/buildings', {
        type,
        size: defines.FETCH_PAGE_SIZE.toString(),
        page: page.toString()
    }) as OutdoorObjectSchema[]
}

export async function search(query: string) {
    return await apiUtils.get('map/search', {
        query,
        size: defines.FETCH_PAGE_SIZE.toString()
    }) as MapSearchResult
}
