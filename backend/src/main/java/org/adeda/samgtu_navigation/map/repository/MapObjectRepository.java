package org.adeda.samgtu_navigation.map.repository;

import org.adeda.samgtu_navigation.map.model.MapObject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MapObjectRepository extends CrudRepository<MapObject, Integer> {
    @Query(value =
        """
        SELECT map_objects.id, domain_id, type, images_urls, name_key, description_key
        FROM map_objects
        INNER JOIN localized_strings ON (key = name_key OR key = description_key)
        WHERE to_tsvector((:configName)::::regconfig, text) @@ plainto_tsquery((:configName)::::regconfig, :query)
        ORDER BY map_objects.id ASC
        LIMIT :limit OFFSET :offset
        """,
        nativeQuery = true
    )
    List<MapObject> search(String query, String configName, int limit, int offset);
}
