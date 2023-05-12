package org.adeda.samgtu_navigation.map.repository;

import org.adeda.samgtu_navigation.map.model.MapBuilding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MapBuildingRepository extends JpaRepository<MapBuilding, Integer> {
    @Query(value =
        """
        WITH ls AS (
            SELECT key FROM localized_strings WHERE
            to_tsvector((:configName)::::regconfig, text) @@ plainto_tsquery((:configName)::::regconfig, :query)
        )
        SELECT * FROM map_buildings, ls WHERE name_key = ls.key
        UNION
        SELECT * FROM map_buildings, ls WHERE description_key = ls.key
        ORDER BY id ASC
        LIMIT :limit OFFSET :offset
        """,
        nativeQuery = true
    )
    List<MapBuilding> search(String query, String configName, int limit, int offset);
}
