package org.adeda.samgtu_navigation.map.repository;

import org.adeda.samgtu_navigation.map.model.MapBuilding;
import org.adeda.samgtu_navigation.map.model.OutdoorObject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface OutdoorObjectRepository extends PagingAndSortingRepository<OutdoorObject, Integer>,
    CrudRepository<OutdoorObject, Integer>
{
    @Query(value = """
        
        """,
        nativeQuery = true
    )
    List<OutdoorObject> search(String query, int limit, int offset);
}
