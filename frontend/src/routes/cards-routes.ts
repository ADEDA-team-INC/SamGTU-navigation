import { RouteRecordRaw } from 'vue-router'
import ObjectsCard from '../components/cards/ObjectsCard.vue'
import MapBuildingCard from '../components/cards/MapBuildingCard.vue'
import MapDomainCard from '../components/cards/MapDomainCard.vue'
import MapObjectCard from '../components/cards/MapObjectCard.vue'
import OutdoorObjectCard from '../components/cards/OutdoorObjectCard.vue'

const routes: RouteRecordRaw[] = [
    { path: '/', component: ObjectsCard },
    { path: '/building/:id', component: MapBuildingCard },
    { path: '/building/:building_id/domain/:domain_id', component: MapDomainCard },
    { path: '/building/:building_id/domain/:domain_id/object/:object_id', component: MapObjectCard },
    { path: '/outdoor_object/:id', component: OutdoorObjectCard },
]

export default routes;
