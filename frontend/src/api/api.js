import axios from 'axios'

const instance = axios.create({
    baseURL: 'http://localhost:8080/'
})

export const mainAPI = {
    getBuildings(map) {
        return instance.get(`${map}/buildings`)
    },

    getCurrentBuilding(map, id) {
        return instance.get(`${map}/building/${id}`)
    },

    getCurrentDomainBuilding(map, id) {
        return instance.get(`${map}/domain/${id}`)
    },
    
    getOutdoorObjects(map) {
        return instance.get(`${map}/outdoor_objects`)
    }
}