package org.adeda.samgtu_navigation.navigation.repository;

import org.adeda.samgtu_navigation.navigation.model.NavNode;
import org.adeda.samgtu_navigation.navigation.model.NodesConnection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NodeRepository extends CrudRepository<NavNode, Integer> {
    @Query("""
        SELECT node FROM NavNode node
        JOIN node.mapObject obj
        JOIN obj.domain d
        JOIN domain.building b
        WHERE b.id = ?1
        """)
    List<NavNode> findByBuildingId(Integer buildingId);

    // TODO: оптимизировать запрос
    @Query("""
        SELECT n FROM NodesConnection n
        JOIN n.nodeA n1
        JOIN n.nodeB n2
        WHERE n1.id IN ?1 AND n2.id IN ?2
        """)
    List<NodesConnection> findConnections(List<Integer> nodesIds);
}
