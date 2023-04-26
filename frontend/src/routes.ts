import { RouteRecordRaw } from 'vue-router'
import MainList from './views/cards/MainList.vue'
import BuildingListCard from './views/cards/BuildingsList.vue'
import BuildingCard from './views/cards/BuildingCard.vue'
import MapObjectCard from './views/cards/MapObjectCard.vue'
import OutdoorObjectCard from './views/cards/OutdoorObjectCard.vue'
import OutdoorObjectsList from './views/cards/OutdoorObjectsList.vue'
import SearchResultsVue from './views/cards/SearchResults.vue'

const routes: RouteRecordRaw[] = [
    { name: 'main', path: '/', component: MainList },
    { name: 'map_buildings_list', path: '/buildings', component: BuildingListCard, },
    { name: 'map_building', path: '/building/:id', component: BuildingCard },
    { name: 'map_object', path: '/object/:id', component: MapObjectCard },
    { name: 'outdoor_objects_list', path: '/outdoor_objects', component: OutdoorObjectsList },
    { name: 'outdoor_object', path: '/outdoor_object/:id', component: OutdoorObjectCard },
    { name: 'search', path: '/search', component: SearchResultsVue }
]

export default routes;
