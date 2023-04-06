import {mainAPI} from '../api/api'

const SET_BUILDINGS = 'SET_BUILDINGS'
const SET_BUILDING = 'SET_BUILDING'


const initialState = {
    buildings: [],
    currentBuilding: {},
}

export const mainReducer = (state = initialState, action) => {
    switch (action.type) {
        case SET_BUILDINGS:
            return {...state, buildings: action.buildings}
        
        case SET_BUILDING:
            return {...state, currentBuilding: action.currentBuilding}
    }
}

const setBuildings = (buildings) => ({type: SET_BUILDINGS, buildings})
const setCurrentBuilding = (currentBuilding) => ({type: SET_BUILDING, currentBuilding})

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