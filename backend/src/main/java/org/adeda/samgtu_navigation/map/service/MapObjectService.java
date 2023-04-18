package org.adeda.samgtu_navigation.map.service;

import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.map.model.MapObject;
import org.adeda.samgtu_navigation.map.schema.map_object.MapObjectCreateSchema;

import java.util.Optional;

public interface MapObjectService {
    MapObject create(Integer domainId, MapObjectCreateSchema schema) throws NotFoundException;

    Optional<MapObject> getById(Integer id);

    MapObject updateById(Integer id, MapObjectCreateSchema schema) throws NotFoundException;

    void deleteById(Integer id) throws NotFoundException;
}
