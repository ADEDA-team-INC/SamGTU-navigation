package org.adeda.samgtu_navigation.map.service;

import jakarta.annotation.Nullable;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.map.enums.OutdoorObjectType;
import org.adeda.samgtu_navigation.map.model.OutdoorObject;
import org.adeda.samgtu_navigation.map.schema.outdoor_object.OutdoorObjectCreateSchema;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface OutdoorObjectService {
    OutdoorObject create(OutdoorObjectCreateSchema schema);

    List<OutdoorObject> getAll(@Nullable OutdoorObjectType type, Pageable pageable);

    Optional<OutdoorObject> getById(Integer id);

    OutdoorObject updateById(Integer id, OutdoorObjectCreateSchema schema) throws NotFoundException;

    void deleteById(Integer id) throws NotFoundException;
}
