const defaultState = {
    map: {}
}

export const mapReducer = (state = defaultState, action) => {
    switch (action.type) {
        case "MAP":
            return {...state, map: action.payload}
        default:
            return state
    }
}