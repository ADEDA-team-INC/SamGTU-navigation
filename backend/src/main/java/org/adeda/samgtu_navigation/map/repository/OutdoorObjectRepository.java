package org.adeda.samgtu_navigation.map.repository;

import org.adeda.samgtu_navigation.map.enums.OutdoorObjectType;
import org.adeda.samgtu_navigation.map.model.OutdoorObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OutdoorObjectRepository extends CrudRepository<OutdoorObject, Integer> {
    @Query("SELECT o FROM OutdoorObject o WHERE ?1 IS NULL OR o.type = ?1")
    List<OutdoorObject> findAll(OutdoorObjectType type, Pageable pageable);

    @Query(value =
        """
        SELECT outdoor_objects.id, type, latitude, longitude, images_urls, name_key, description_key
        FROM outdoor_objects
        INNER JOIN localized_strings ON (key = name_key OR key = description_key)
        WHERE to_tsvector((:configName)::::regconfig, text) @@ plainto_tsquery((:configName)::::regconfig, :query)
        ORDER BY outdoor_objects.id ASC
        LIMIT :limit OFFSET :offset
        """,
        nativeQuery = true
    )
    List<OutdoorObject> search(String query, String configName, int limit, int offset);
}
