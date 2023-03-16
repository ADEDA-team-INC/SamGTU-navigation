package org.adeda.samgtu_navigation.map.repository;

import org.adeda.samgtu_navigation.map.model.MapDomain;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MapDomainRepository extends CrudRepository<MapDomain, Integer> {
    List<MapDomain> findByBuildingId(Integer id);
}
