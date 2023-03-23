import axios from 'axios'

const instance = axios.create({
    baseURL: 'http://localhost:8080/'
})

export const mainAPI = {
    getData(map) {
        return instance.get(`${map}`)
    }
}