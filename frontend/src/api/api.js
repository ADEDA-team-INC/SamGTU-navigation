import axios from 'axios'

const instance = axios.create({
    baseURL: 'http://localhost:8080'
})

export const mainAPI = {
    getBuildings() {
        return instance.get(`/map/buildings`)
    },

    getCurrentBuilding(id) {
        return instance.get(`/map/building/${id}`)
    },

    getCurrentDomainBuilding(id) {
        return instance.get(`/map/domain/${id}`)
    },

    getOutdoorObjects() {
        return instance.get(`/map/outdoor_objects`)
    },

    getCurrentOutdoorObject(id) {
        return instance.get(`/map/outdoor_object/${id}`)
    },

    search(query) {
        return instance.get(`/map/search`, {
            params: { query }
        }
        )
    },

    getMapObject(id) {
        return instance.get(`map/object/${id}`)
    }
}