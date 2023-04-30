import  thunkMiddleware  from "redux-thunk";

import {
    applyMiddleware,
    combineReducers,
    compose,
    createStore
} from 'redux';

import { mainReducer } from './mainReducer';
import { mapReducer } from "./mapReducer";

const reducers = combineReducers({
    main: mainReducer,
    map: mapReducer
})

const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose

export const store = createStore(reducers, composeEnhancers(
    applyMiddleware(thunkMiddleware)
))

window.store = store