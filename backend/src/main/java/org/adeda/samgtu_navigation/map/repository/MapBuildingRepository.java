package org.adeda.samgtu_navigation.map.repository;

import org.adeda.samgtu_navigation.map.model.MapBuilding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MapBuildingRepository extends JpaRepository<MapBuilding, Integer> {
    @Query(value =
        """
        SELECT map_buildings.id, latitude, longitude, images_urls, name_key, description_key
        FROM map_buildings
        INNER JOIN localized_strings ON (key = name_key OR key = description_key)
        WHERE to_tsvector((:configName)::::regconfig, text) @@ plainto_tsquery((:configName)::::regconfig, :query)
        ORDER BY map_buildings.id ASC
        LIMIT :limit OFFSET :offset
        """,
        nativeQuery = true
    )
    List<MapBuilding> search(String query, String configName, int limit, int offset);
}
