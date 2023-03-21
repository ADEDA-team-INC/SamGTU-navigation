import {mainAPI} from '../api/api'

const SET_DATA = 'SET_DATA'


const initialState = {
    data: [],
}

export const mainReducer = (state = initialState, action) => {
    switch (action.type) {
        case SET_DATA:
            return {...state, data: action.data}
    }
}

const setData = (data) => ({type: SET_DATA, data})

export const requestData = (map) => async (dispatch) => {
    const response = await mainAPI.getData(map)
    if (response.status === 200) {
        dispatch(setData(response.data.results))
    } else {
        console.log(response)
    }
}