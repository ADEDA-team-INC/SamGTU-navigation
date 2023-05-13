import { RouteRecordRaw } from 'vue-router'
import MainList from './views/cards/MainList.vue'
import BuildingListCard from './views/cards/BuildingsList.vue'
import BuildingCard from './views/cards/BuildingCard.vue'
import MapObjectCard from './views/cards/MapObjectCard.vue'
import OutdoorObjectCard from './views/cards/OutdoorObjectCard.vue'
import OutdoorObjectsList from './views/cards/OutdoorObjectsList.vue'
import SearchResults from './views/cards/SearchResults.vue'

const routes: RouteRecordRaw[] = [
    {
        name: 'main',
        path: '/',
        component: MainList,
        meta: { titleKey: 'main_page.title' }
    },
    {
        name: 'map_buildings_list',
        path: '/buildings',
        component: BuildingListCard,
        meta: { titleKey: 'map_buildings_list.title' }
    },
    {
        name: 'map_building',
        path: '/building/:id',
        component: BuildingCard,
        meta: { titleKey: 'map_building.title' }
    },
    {
        name: 'map_object',
        path: '/object/:id',
        component: MapObjectCard,
        meta: { titleKey: 'map_object.title' }
    },
    {
        name: 'outdoor_objects_list',
        path: '/outdoor_objects',
        component: OutdoorObjectsList,
        meta: { titleKey: 'outdoor_objects_list.title' }
    },
    {
        name: 'outdoor_object',
        path: '/outdoor_object/:id',
        component: OutdoorObjectCard,
        meta: { titleKey: 'outdoor_object.title' }
    },
    {
        name: 'search',
        path: '/search',
        component: SearchResults,
        meta: { titleKey: 'searching.title' } 
    }
]

export default routes;
