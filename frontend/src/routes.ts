import { RouteRecordRaw } from 'vue-router'
import ObjectsCard from './views/cards/MainList.vue'
import BuildingListCard from './views/cards/BuildingsList.vue'
import BuildingCard from './views/cards/BuildingCard.vue'
import DomainCard from './views/cards/DomainCard.vue'
import MapObjectCard from './views/cards/MapObjectCard.vue'
import OutdoorObjectCard from './views/cards/OutdoorObjectCard.vue'
import OutdoorObjectsList from './views/cards/OutdoorObjectsList.vue'

const routes: RouteRecordRaw[] = [
    { path: '/', component: ObjectsCard },
    { path: '/buildings', component: BuildingListCard, },
    { path: '/building/:id', component: BuildingCard },
    { path: '/domain/:domain_id', component: DomainCard },
    { path: '/object/:object_id', component: MapObjectCard },
    { path: '/outdoor_objects', component: OutdoorObjectsList },
    { path: '/outdoor_object/:id', component: OutdoorObjectCard },
]

export default routes;
