import defines from '../defines'
import { useUserStore } from '../stores/user-store'

async function get(path: string, params: { [key: string]: string | null }) {
    const userStore = useUserStore()

    let url = new URL(path, defines.API_BASE_URL)
    for (const [key, value] of Object.entries(params)) {
        if (typeof value === 'string') {
            url.searchParams.append(key, value)
        }
    }

    let options = {
        headers: {
            'Accept-Language': userStore.locale
        }
    }

    let result = await fetch(url, options)

    if (!result.ok) {
        throw new Error(`Error occured while fetching ${path} with status code ${result.status}`)
    }

    return await result.json()
}

export default {
    get
}
