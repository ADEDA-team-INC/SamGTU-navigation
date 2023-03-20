package org.adeda.samgtu_navigation.navigation.graph;

import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.core.util.Vector2;
import org.adeda.samgtu_navigation.navigation.model.NavNode;

import java.util.List;

public interface Graph {
    NavNode findClosestNode(Integer domainId, Vector2 position) throws NotFoundException;

    Double getNodesDistance(NavNode node1, NavNode node2) throws NotFoundException;

    List<NavNode> findPath(NavNode startNode, NavNode endNode) throws NotFoundException;
}
