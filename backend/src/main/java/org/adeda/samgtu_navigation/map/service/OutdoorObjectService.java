package org.adeda.samgtu_navigation.map.service;

import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.map.model.OutdoorObject;
import org.adeda.samgtu_navigation.map.schema.outdoor_object.OutdoorObjectCreateSchema;

import java.util.List;
import java.util.Optional;

public interface OutdoorObjectService {
    OutdoorObject create(OutdoorObjectCreateSchema schema);

    List<OutdoorObject> getAll(int size, int page);

    Optional<OutdoorObject> getById(Integer id);

    OutdoorObject updateById(Integer id, OutdoorObjectCreateSchema schema) throws NotFoundException;

    void deleteById(Integer id) throws NotFoundException;
}
