package org.adeda.samgtu_navigation.map.service;

import org.adeda.samgtu_navigation.core.exception.EntityDependsException;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.map.model.MapBuilding;
import org.adeda.samgtu_navigation.map.schema.map_building.MapBuildingCreateSchema;

import java.util.List;
import java.util.Optional;

public interface MapBuildingService {
    MapBuilding create(MapBuildingCreateSchema schema);

    List<MapBuilding> getAll(int size, int page);

    Optional<MapBuilding> getById(Integer id);

    MapBuilding updateById(Integer id, MapBuildingCreateSchema schema) throws NotFoundException;

    void deleteById(Integer id) throws NotFoundException, EntityDependsException;
}
