import axios from 'axios'

const instance = axios.create({
    baseURL: 'https://example/'
})

export const mainAPI = {
    getData(map) {
        return instance.get(`${map}`)
    }
}