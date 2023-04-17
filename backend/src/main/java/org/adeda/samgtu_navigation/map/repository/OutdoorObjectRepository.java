package org.adeda.samgtu_navigation.map.repository;

import org.adeda.samgtu_navigation.map.model.OutdoorObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OutdoorObjectRepository extends JpaRepository<OutdoorObject, Integer> {
    @Query(value =
        """
        SELECT * FROM outdoor_objects LIMIT :limit OFFSET :offset --:query
        """,
        nativeQuery = true
    )
    List<OutdoorObject> search(String query, int limit, int offset);
}
