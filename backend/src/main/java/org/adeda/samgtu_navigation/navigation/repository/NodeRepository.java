package org.adeda.samgtu_navigation.navigation.repository;

import org.adeda.samgtu_navigation.navigation.model.NavNode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NodeRepository extends CrudRepository<NavNode, Integer> {
    @Query("""
        SELECT node FROM NavNode node
        JOIN node.mapObject obj
        JOIN obj.domain d
        JOIN d.building b
        WHERE b.id = ?1
        """)
    List<NavNode> findByBuildingId(Integer buildingId);
}
