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
        WITH ls AS (
            SELECT key FROM localized_strings WHERE
            to_tsvector((:configName)::::regconfig, text) @@ plainto_tsquery((:configName)::::regconfig, :query)
        )
        SELECT * FROM outdoor_objects, ls WHERE name_key = ls.key
        UNION
        SELECT * FROM outdoor_objects, ls WHERE description_key = ls.key
        ORDER BY id ASC
        LIMIT :limit OFFSET :offset
        """,
        nativeQuery = true
    )
    List<OutdoorObject> search(String query, String configName, int limit, int offset);
}
