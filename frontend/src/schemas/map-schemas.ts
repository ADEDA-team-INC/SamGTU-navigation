
export interface MapBuildingSchema {
    id: number
    latitude: number
    longitude: number
    displayName: string
    displayDescription: string
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
    displayName: string
    displayDescription: string
    bboxes: BoundingBox[]
}
