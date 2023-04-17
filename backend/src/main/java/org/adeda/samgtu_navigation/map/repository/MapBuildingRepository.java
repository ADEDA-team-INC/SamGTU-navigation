package org.adeda.samgtu_navigation.map.repository;

import org.adeda.samgtu_navigation.map.model.MapBuilding;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MapBuildingRepository extends PagingAndSortingRepository<MapBuilding, Integer>,
    CrudRepository<MapBuilding, Integer>
{
    @Query(value = """
        
        """,
        nativeQuery = true
    )
    List<MapBuilding> search(String query, int limit, int offset);
}
