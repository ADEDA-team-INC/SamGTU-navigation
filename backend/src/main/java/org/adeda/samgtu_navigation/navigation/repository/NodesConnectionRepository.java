package org.adeda.samgtu_navigation.navigation.repository;

import org.adeda.samgtu_navigation.navigation.model.NavNode;
import org.adeda.samgtu_navigation.navigation.model.NodesConnection;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface NodesConnectionRepository extends CrudRepository<NodesConnection, Integer> {
    Optional<NodesConnection> findByNodeAAndNodeB(NavNode nodeA, NavNode nodeB);
}
