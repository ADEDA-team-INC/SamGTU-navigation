import { RouteRecordRaw } from 'vue-router'
import ObjectsCard from '../components/cards/ObjectsCard.vue'
import BuildingListCard from '../components/cards/BuildingsListCard.vue'
import BuildingCard from '../components/cards/BuildingCard.vue'
import DomainCard from '../components/cards/DomainCard.vue'
import MapObjectCard from '../components/cards/MapObjectCard.vue'
import OutdoorObjectCard from '../components/cards/OutdoorObjectCard.vue'

const routes: RouteRecordRaw[] = [
    { path: '/', component: ObjectsCard },
    { path: '/buildings', component: BuildingListCard, },
    { path: '/building/:id', component: BuildingCard },
    { path: '/domain/:domain_id', component: DomainCard },
    { path: '/object/:object_id', component: MapObjectCard },
    { path: '/outdoor_object/:id', component: OutdoorObjectCard },
]

export default routes;
