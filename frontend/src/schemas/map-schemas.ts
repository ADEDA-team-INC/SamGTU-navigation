
export interface InfoSchema {
    images: string[]
    displayName: string
    displayDescription: string
}

export interface MapEntity {
    id: number
    info: InfoSchema
}

export interface MapBuildingSchema extends MapEntity {
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
    Hall = 'HALL',
    Room = 'ROOM',
    Stairs = 'STAIRS',
    Exit = 'EXIT'
}

export interface BoundingBox {
    positionX: number
    positionY: number
    width: number
    height: number
}

export interface MapObjectSchema extends MapEntity {
    id: number
    type: MapObjectType
    info: InfoSchema
    bboxes: BoundingBox[]
}

export interface MapObjectInfo extends MapEntity {
    id: number
    type: MapObjectType
    info: InfoSchema
}

export interface DetailedMapObject extends MapEntity {
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

export interface OutdoorObjectSchema extends MapEntity {
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
