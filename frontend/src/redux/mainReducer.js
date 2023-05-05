import { mainAPI } from '../api/api'

const SET_BUILDINGS = 'SET_BUILDINGS'
const SET_BUILDING = 'SET_BUILDING'
const SET_DOMAIN = 'SET_DOMAIN'
const SET_OUTDOOR = 'SET_OUTDOOR'
const TOGGLE_IS_FETCHING = 'TOGGLE_IS_FETCHING'
const SET_MAP_OBJECT = 'SET_MAP_OBJECT'
const SET_CURRENT_OUTDOOR_OBJECT = 'SET_CURRENT_OUTDOOR_OBJECT'
const SET_SEARCH = 'SET_SEARCH'

const initialState = {
    buildings: [],
    currentBuilding: {},
    currentDomainBuilding: {},
    outdoorObjects: [],
    mapObject: {},
    currentOutdoorObject: {},
    search: {},
    isFetching: false,
}

export const mainReducer = (state = initialState, action) => {
    switch (action.type) {
        case SET_BUILDINGS:
            return { ...state, buildings: action.buildings }

        case SET_BUILDING:
            return { ...state, currentBuilding: action.currentBuilding }

        case SET_DOMAIN:
            return { ...state, currentDomainBuilding: action.currentDomainBuilding }

        case SET_OUTDOOR:
            return { ...state, outdoorObjects: action.outdoorObjects }

        case TOGGLE_IS_FETCHING:
            return { ...state, isFetching: action.isFetching }

        case SET_MAP_OBJECT:
            return {...state, mapObject: action.mapObject}
        
        case SET_CURRENT_OUTDOOR_OBJECT: 
            return {...state, currentOutdoorObject: action.currentOutdoorObject}

        case SET_SEARCH: 
            return {...state, search: action.search}
        default:
            return state
    }
}

const setBuildings = (buildings) => ({ type: SET_BUILDINGS, buildings })
const setCurrentBuilding = (currentBuilding) => ({ type: SET_BUILDING, currentBuilding })
const setCurrentDomainBuilding = (currentDomainBuilding) => ({ type: SET_DOMAIN, currentDomainBuilding })
const setOutdoorObjects = (outdoorObjects) => ({ type: SET_OUTDOOR, outdoorObjects })
const setMapObject = (mapObject) => ({type: SET_MAP_OBJECT, mapObject})
const setCurrentOutdoorObject = (currentOutdoorObject) => ({type: SET_CURRENT_OUTDOOR_OBJECT, currentOutdoorObject})
const setSearch = (search) => ({type: SET_SEARCH, search})
const toggleIsFetching = (isFetching) => ({ type: TOGGLE_IS_FETCHING, isFetching })

export const requestBuildings = () => async (dispatch) => {
    dispatch(toggleIsFetching(true))
    const response = await mainAPI.getBuildings()
    if (response.status === 200) {
        dispatch(setBuildings(response.data))
        dispatch(toggleIsFetching(false))
        console.log(response.data)
    } else {
        console.log(response)
        dispatch(toggleIsFetching(false))
    }
}

export const requestBuildingById = (id) => async (dispatch) => {
    dispatch(toggleIsFetching(true))
    const response = await mainAPI.getCurrentBuilding(id)
    if (response.status === 200) {
        dispatch(setCurrentBuilding(response.data))
        dispatch(toggleIsFetching(false))
        console.log(response.data)
    } else {
        console.log(response)
        dispatch(toggleIsFetching(false))
    }
}

export const requestDomainBuilding = (id) => async (dispatch) => {
    dispatch(toggleIsFetching(true))
    const response = await mainAPI.getCurrentDomainBuilding(id)
    if (response.status === 200) {
        dispatch(setCurrentDomainBuilding(response.data))
        dispatch(toggleIsFetching(false))
    } else {
        console.log(response)
        dispatch(toggleIsFetching(false))
    }
}

export const requestOutdoorObjects = (id) => async (dispatch) => {
    dispatch(toggleIsFetching(true))
    const response = await mainAPI.getOutdoorObjects()
    if (response.status === 200) {
        dispatch(setOutdoorObjects(response.data))
        dispatch(toggleIsFetching(false))
    } else {
        console.log(response)
        dispatch(toggleIsFetching(false))
    }
}

export const requestMapObjectById = (id) => async (dispatch) => {
    dispatch(toggleIsFetching(true))
    const response = await mainAPI.getMapObject(id)
    if (response.status === 200) {
        dispatch(setMapObject(response.data))
        dispatch(toggleIsFetching(false))
    } else {
        console.log(response)
        dispatch(toggleIsFetching(false))
    }
}

export const requestCurrentOutdoorObject = (id) => async (dispatch) => {
    dispatch(toggleIsFetching(true))
    const response = await mainAPI.getCurrentOutdoorObject(id)
    if (response.status === 200) {
        dispatch(setCurrentOutdoorObject(response.data))
        dispatch(toggleIsFetching(false))
    } else {
        console.log(response)
        dispatch(toggleIsFetching(false))
    }
}

export const requestSearch = () => async (dispatch) => {
    dispatch(toggleIsFetching(true))
    const response = await mainAPI.search()
    if (response.status === 200) {
        dispatch(setSearch(response.data))
        dispatch(toggleIsFetching(false))
    } else {
        console.log(response)
        dispatch(toggleIsFetching(false))
    }
}