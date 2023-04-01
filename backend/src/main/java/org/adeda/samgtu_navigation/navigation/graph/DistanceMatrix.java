package org.adeda.samgtu_navigation.navigation.graph;

import org.adeda.samgtu_navigation.core.util.Pair;
import org.adeda.samgtu_navigation.navigation.model.NavNode;

import java.util.HashMap;

public class DistanceMatrix {
    private final HashMap<Pair<NavNode, NavNode>, Double> matrix;

    public DistanceMatrix(HashMap<Pair<NavNode, NavNode>, Double> matrix) {
        this.matrix = matrix;
    }

    public double getDistance(NavNode firstNode, NavNode secondNode) {
        var pair = new Pair<>(firstNode, secondNode);

        if (matrix.containsKey(pair)) {
            return matrix.get(pair);
        }

        return matrix.get(pair.swap());
    }
}
