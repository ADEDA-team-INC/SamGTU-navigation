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
        SELECT * FROM outdoor_objects LIMIT :limit OFFSET :offset --:query
        """,
        nativeQuery = true
    )
    List<OutdoorObject> search(String query, int limit, int offset);
}
