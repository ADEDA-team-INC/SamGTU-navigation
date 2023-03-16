package org.adeda.samgtu_navigation.map.service;

import org.adeda.samgtu_navigation.map.schema.MapBuildingSchema;
import org.adeda.samgtu_navigation.map.schema.MapDomainSchema;

public interface MapService {
    MapBuildingSchema getBuildingById(Integer id);

    MapDomainSchema getDomainById(Integer id);
}
