package org.adeda.samgtu_navigation.map.repository;

import org.adeda.samgtu_navigation.map.model.MapBuilding;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface MapBuildingRepository extends PagingAndSortingRepository<MapBuilding, Integer> {
    boolean existsById(Integer id);

    Optional<MapBuilding> findById(Integer id);
}
