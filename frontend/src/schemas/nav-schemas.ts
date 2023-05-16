import { DetailedMapObject } from "./map-schemas"

export interface LocationPoint {
    positionX: number
    positionY: number
    mapObject: DetailedMapObject
}

export interface NavigationPoint {
    positionX: number
    positionY: number
    mapObjectId: number
}
