package org.adeda.samgtu_navigation.map.repository;

import org.adeda.samgtu_navigation.map.model.MapObject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MapObjectRepository extends CrudRepository<MapObject, Integer> {
    @Query(value =
        """
        WITH ls AS (
            SELECT key FROM localized_strings WHERE
            to_tsvector((:configName)::::regconfig, text) @@ plainto_tsquery((:configName)::::regconfig, :query)
        )
        SELECT * FROM map_objects, ls WHERE name_key = ls.key
        UNION
        SELECT * FROM map_objects, ls WHERE description_key = ls.key
        ORDER BY id ASC
        LIMIT :limit OFFSET :offset
        """,
        nativeQuery = true
    )
    List<MapObject> search(String query, String configName, int limit, int offset);
}
