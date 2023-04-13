import defines from '../defines'
import { delay } from '../utils'
import { MapBuildingSchema, MapDomainSchema, MapObjectType } from '../schemas/map-schemas'

const buildings = new Map<number, MapBuildingSchema>([
    [1, {
        id: 1,
        latitude: 0.0,
        longitude: 0.0,
        displayName: 'Корпус №8',
        displayDescription: 'Молодогвардейская ул., 244',
        domainIds: { '-1': 1, '1': 2 }
    }],
    [2, {
        id: 2,
        latitude: 0.0,
        longitude: 0.0,
        displayName: 'Корпус №9',
        displayDescription: 'Ново-Садовая ул., 10',
        domainIds: { '1': 3, '2': 4 }
    }],
    [3, {
        id: 3,
        latitude: 0.0,
        longitude: 0.0,
        displayName: 'Корпус №14',
        displayDescription: 'Ново-Садовая ул., 14',
        domainIds: {}
    }]
])

const domains = new Map<number, MapDomainSchema>([
    [1, {
        id: 1,
        mapBuildingId: 1,
        image: {
            url: '',
            width: 100.0,
            offsetX: 0.0,
            offsetY: 0.0
        },
        mapObjects: [
            { id: 1, type: MapObjectType.Room, displayName: 'Аудитория 1', displayDescription: '', bboxes: [] }
        ]
    }],
    [2, {
        id: 2,
        mapBuildingId: 1,
        image: {
            url: '',
            width: 100.0,
            offsetX: 0.0,
            offsetY: 0.0
        },
        mapObjects: [
            { id: 1, type: MapObjectType.Room, displayName: 'Аудитория 101', displayDescription: '', bboxes: [] }
        ]
    }],
    [3, {
        id: 3,
        mapBuildingId: 1,
        image: {
            url: '',
            width: 100.0,
            offsetX: 0.0,
            offsetY: 0.0
        },
        mapObjects: [
            { id: 1, type: MapObjectType.Room, displayName: 'Аудитория 100', displayDescription: 'Преподовательская', bboxes: [] }
        ]
    }],
    [4, {
        id: 4,
        mapBuildingId: 1,
        image: {
            url: '',
            width: 100.0,
            offsetX: 0.0,
            offsetY: 0.0
        },
        mapObjects: [
            { id: 1, type: MapObjectType.Room, displayName: 'Аудитория 201', displayDescription: 'Лекционная', bboxes: [] }
        ]
    }],
])

export async function fetchBuildings(page: number) {
    let ids = Array.from(buildings.keys())
    ids = ids.slice(page * defines.FETCH_PAGE_SIZE, (page + 1) * defines.FETCH_PAGE_SIZE)

    await delay(500)

    return ids.map((id) => buildings.get(id) as MapBuildingSchema)
}

export async function fetchBuildingById(id: number) {
    await delay(500)
    return buildings.get(id)
}

export async function fetchDomainById(id: number) {
    await delay(500)
    return domains.get(id)
}
