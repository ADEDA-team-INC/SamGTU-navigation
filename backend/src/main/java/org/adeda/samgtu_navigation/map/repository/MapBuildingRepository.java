package org.adeda.samgtu_navigation.map.repository;

import org.adeda.samgtu_navigation.map.model.MapBuilding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MapBuildingRepository extends JpaRepository<MapBuilding, Integer> {
    @Query(value =
        """
        SELECT * FROM map_buildings LIMIT :limit OFFSET :offset --:query
        """,
        nativeQuery = true
    )
    List<MapBuilding> search(String query, int limit, int offset);
}
