package org.adeda.samgtu_navigation.map.controller;

import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.map.schema.MapBuildingSchema;
import org.adeda.samgtu_navigation.map.schema.MapDomainSchema;
import org.adeda.samgtu_navigation.map.schema.OutdoorObjectSchema;

import java.util.List;

public interface MapController {
    List<MapBuildingSchema> getAllMapBuildings(int page, int size);

    MapBuildingSchema getMapBuildingById(Integer id) throws NotFoundException;

    MapDomainSchema getMapDomainById(Integer id) throws NotFoundException;

    List<OutdoorObjectSchema> getAllOutdoorObjects(int page, int size);
}
