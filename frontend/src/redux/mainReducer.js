import {mainAPI} from '../api/api'

const SET_BUILDINGS = 'SET_BUILDINGS'
const SET_BUILDING = 'SET_BUILDING'
const SET_DOMAIN = 'SET_DOMAIN'
const SET_OUTDOOR = 'SET_OUTDOOR'

const initialState = {
    buildings: [],
    currentBuilding: {},
    currentDomainBuilding: {},
    outdoorObjects: []
}

export const mainReducer = (state = initialState, action) => {
    switch (action.type) {
        case SET_BUILDINGS:
            return {...state, buildings: action.buildings}
        
        case SET_BUILDING:
            return {...state, currentBuilding: action.currentBuilding}
        
        case SET_DOMAIN:
            return {...state, currentDomainBuilding: action.currentDomainBuilding}
        
        case SET_OUTDOOR:
            return {...state, outdoorObjects: action.outdoorObjects}
        default: 
            return state
    }
}

const setBuildings = (buildings) => ({type: SET_BUILDINGS, buildings})
const setCurrentBuilding = (currentBuilding) => ({type: SET_BUILDING, currentBuilding})
const setCurrentDomainBuilding = (currentDomainBuilding) => ({type: SET_DOMAIN, currentDomainBuilding})
const setOutdoorObjects = (outdoorObjects) => ({type: SET_OUTDOOR, outdoorObjects})

export const requestBuildings = (map) => async (dispatch) => {
    const response = await mainAPI.getBuildings(map)
    if (response.status === 200) {
        dispatch(setBuildings(response.data.results))
    } else {
        console.log(response)
    }
}

export const requestBuilding = (map, id) => async (dispatch) => {
    const response = await mainAPI.getCurrentBuilding(map, id)
    if (response.status === 200) {
        dispatch(setCurrentBuilding(response.data.results))
    } else {
        console.log(response)
    }
}

export const requestDomainBuilding = (map) => async (dispatch) => {
    const response = await mainAPI.getOutdoorObjects(map)
    if (response.status === 200) {
        dispatch(setCurrentDomainBuilding(response.data.results))
    } else {
        console.log(response)
    }
}

export const requestOutdoorObjects = (map, id) => async (dispatch) => {
    const response = await mainAPI.getCurrentDomainBuilding(map, id)
    if (response.status === 200) {
        dispatch(setOutdoorObjects(response.data.results))
    } else {
        console.log(response)
    }
}