package org.adeda.samgtu_navigation.navigation.graph;

import lombok.Getter;
import org.adeda.samgtu_navigation.core.exception.InvalidFormatException;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.navigation.model.NavNode;

import java.util.*;

@Getter
public class GraphImpl implements Graph {
    private final Set<NavNode> nodes;
    private final DistanceMatrix matrix;

    public GraphImpl(Set<NavNode> nodes, DistanceMatrix matrix) {
        this.nodes = nodes;
        this.matrix = matrix;
    }

    @Override
    public List<NavNode> findPath(NavNode startNode, NavNode endNode) throws NotFoundException, InvalidFormatException {
        if (!nodes.contains(startNode) || !nodes.contains(endNode)) {
            throw new InvalidFormatException("startNode and endNode must belong to graph nodes");
        }

        // Множество рассматриваемых вершин
        var openSet = new TreeSet<NavNode>(
            (a, b) -> Double.compare(
                matrix.getDistance(a, endNode), matrix.getDistance(b, endNode)
            )
        );
        openSet.add(startNode);

        // Множество пройденных вершин
        var closedSet = new HashSet<NavNode>();

        // Таблица стоимостей пути от начального узла до данного
        var g = new HashMap<NavNode, Double>();
        g.put(startNode, 0.0);

        // Таблица с подходящим родителем для данной вершины
        var parents = new HashMap<NavNode, NavNode>();

        // Найден ли путь
        boolean found = false;

        while (!openSet.isEmpty()) {
            // Ищем узел ближайший к конечному узлу
            var curr = openSet.first();

            // Если нашли конечный узел
            if (curr == endNode) {
                found = true;
                break;
            }

            openSet.remove(curr);
            closedSet.add(curr);

            // Рассматриваем все смежные узлы
            for (var conn : curr.getConnections()) {
                var joined = conn.getNodeB();
                var score = g.get(curr) + matrix.getDistance(curr, joined);

                // Если оценка оказалась хуже
                if (closedSet.contains(joined) && score >= g.get(joined)) {
                    continue;
                }

                // Если оценка оказалась лучше
                if (!closedSet.contains(joined) || score < g.get(joined)) {
                    parents.put(joined, curr);
                    g.put(joined, score);
                    openSet.add(joined);
                }
            }
        }

        if (!found) {
            throw new NotFoundException("Unable to find path between " + startNode + " and " + endNode);
        }

        var path = new LinkedList<NavNode>();

        // Восстанавливаем путь
        var curr = endNode;
        while (curr != null) {
            path.addFirst(curr);
            curr = parents.get(curr);
        }

        return path;
    }
}
