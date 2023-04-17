package org.adeda.samgtu_navigation.map.repository;

import org.adeda.samgtu_navigation.map.model.MapBuilding;
import org.adeda.samgtu_navigation.map.model.MapObject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MapObjectRepository extends CrudRepository<MapObject, Integer> {
    @Query(value =
        """
        SELECT * FROM map_objects LIMIT :limit OFFSET :offset --:query
        """,
        nativeQuery = true
    )
    List<MapObject> search(String query, int limit, int offset);
}
