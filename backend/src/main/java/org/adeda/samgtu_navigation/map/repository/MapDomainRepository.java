package org.adeda.samgtu_navigation.map.repository;

import org.adeda.samgtu_navigation.map.model.MapDomain;
import org.adeda.samgtu_navigation.navigation.model.NavNode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MapDomainRepository extends CrudRepository<MapDomain, Integer> {
    List<MapDomain> findByBuildingId(Integer id);

    @Query("SELECT n FROM MapDomain d JOIN d.mapObjects o JOIN o.nodes n WHERE d.id = :id")
    List<NavNode> findNodes(Integer id);
}
