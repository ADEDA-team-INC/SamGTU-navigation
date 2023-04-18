
export interface InfoSchema {
    images: string[]
    displayName: string
    displayDescription: string
}

export interface MapBuildingSchema {
    id: number
    latitude: number
    longitude: number
    info: InfoSchema
    domainIds: {
        [key: string]: number
    }
}

export interface DomainImageSchema {
    url: string
    width: number
    offsetX: number
    offsetY: number
}

export interface MapDomainSchema {
    id: number
    mapBuildingId: number
    image: DomainImageSchema
    mapObjects: MapObjectSchema[]
}

export enum MapObjectType {
    Hall = 'Hall',
    Room = 'Room',
    Stairs = 'Stairs',
    Exit = 'Exit'
}

export interface BoundingBox {
    positionX: number
    positionY: number
    width: number
    height: number
}

export interface MapObjectSchema {
    id: number
    type: MapObjectType
    info: InfoSchema
    bboxes: BoundingBox[]
}

export interface MapObjectInfo {
    id: number
    type: MapObjectType
    info: InfoSchema
}

export interface DetailedMapObject {
    id: number
    mapBuildingId: number
    mapDomainId: number
    type: MapObjectType
    info: InfoSchema
}

export enum OutdoorObjectType {
    Sight = 'SIGHT',
    Cafe = 'CAFE',
    Shop = 'SHOP'
}

export interface OutdoorObjectSchema {
    id: number
    type: OutdoorObjectType
    latitude: number
    longitude: number
    info: InfoSchema
}

export interface MapSearchResult {
    mapBuildings: MapBuildingSchema[]
    mapObjects: MapObjectInfo[]
    outdoorObjects: OutdoorObjectSchema[]
}
