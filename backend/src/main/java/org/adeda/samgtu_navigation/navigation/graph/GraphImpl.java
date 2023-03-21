package org.adeda.samgtu_navigation.navigation.graph;

import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.core.util.Vector2d;
import org.adeda.samgtu_navigation.navigation.model.NavNode;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class GraphImpl implements Graph {
    private final List<GraphNode> nodes;
    private final GraphField rootField;
    private final DistanceMatrix distanceMatrix = new DistanceMatrix();

    private final Map<NavNode, GraphNode> graphNodeByNavNode = Map.of();
    private final Map<GraphNode, NavNode> navNodeByGraphNode = Map.of();

    public GraphImpl(List<GraphNode> nodes, GraphField rootField) {
        this.nodes = Collections.unmodifiableList(nodes);
        this.rootField = rootField;

        // TODO: построение матрицы расстояний
    }

    @Override
    public NavNode findClosestNode(Integer domainId, Vector2d position) throws NotFoundException {
        return null;
    }

    @Override
    public Double getNodesDistance(NavNode node1, NavNode node2) throws NotFoundException {
        return null;
    }

    @Override
    public List<NavNode> findPath(NavNode startNode, NavNode endNode) throws NotFoundException {
        return null;
    }
}
