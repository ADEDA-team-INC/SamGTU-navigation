package org.adeda.samgtu_navigation.map.service;

import org.adeda.samgtu_navigation.core.exception.AlreadyExistsException;
import org.adeda.samgtu_navigation.core.exception.EntityDependsException;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.map.model.MapDomain;
import org.adeda.samgtu_navigation.map.schema.map_domain.MapDomainCreateSchema;

import java.util.Optional;

public interface MapDomainService {
    MapDomain create(Integer buildingId, MapDomainCreateSchema schema) throws NotFoundException, AlreadyExistsException;

    Optional<MapDomain> getById(Integer id);

    MapDomain updateById(Integer id, MapDomainCreateSchema schema) throws NotFoundException, AlreadyExistsException;

    void deleteById(Integer id) throws NotFoundException, EntityDependsException;
}
