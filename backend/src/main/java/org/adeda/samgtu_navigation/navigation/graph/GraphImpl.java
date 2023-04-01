package org.adeda.samgtu_navigation.navigation.graph;

import lombok.ToString;
import org.adeda.samgtu_navigation.core.exception.InvalidFormatException;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.navigation.model.NavNode;

import java.util.List;
import java.util.Set;

@ToString
public class GraphImpl implements Graph {
    private final Set<NavNode> nodes;
    private final DistanceMatrix distanceMatrix;

    public GraphImpl(Set<NavNode> nodes, DistanceMatrix distanceMatrix) {
        this.nodes = nodes;
        this.distanceMatrix = distanceMatrix;
    }

    @Override
    public List<NavNode> findPath(NavNode startNode, NavNode endNode) throws NotFoundException, InvalidFormatException {
        throw new UnsupportedOperationException();
    }
}
