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
    private final DistanceMatrix matrix;

    public GraphImpl(Set<NavNode> nodes, DistanceMatrix matrix) {
        this.nodes = nodes;
        this.matrix = matrix;
    }

    @Override
    public List<NavNode> findPath(NavNode startNode, NavNode endNode) throws NotFoundException, InvalidFormatException {
        throw new UnsupportedOperationException();
    }
}
