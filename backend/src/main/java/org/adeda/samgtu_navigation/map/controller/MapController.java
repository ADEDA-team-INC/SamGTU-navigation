package org.adeda.samgtu_navigation.map.controller;

import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.map.schema.MapBuildingSchema;
import org.adeda.samgtu_navigation.map.schema.MapDomainSchema;

public interface MapController {
    MapBuildingSchema getMapBuildingById(Integer id) throws NotFoundException;

    MapDomainSchema getMapDomainById(Integer id) throws NotFoundException;
}
