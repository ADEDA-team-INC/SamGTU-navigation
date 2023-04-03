package org.adeda.samgtu_navigation.navigation.graph;

import org.adeda.samgtu_navigation.core.util.Pair;
import org.adeda.samgtu_navigation.navigation.model.NavNode;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Component
public class GraphFactory {
    /**
     * Метод создания нового графа. Внутри заранее просчитывает матрицу расстояний
     * для всех узлов.
     * @param nodes список узлов, по которым необходимо создать граф
     * @return Новый объект графа
     */
    public Graph createGraph(List<NavNode> nodes) {
        var matrix = new HashMap<Pair<NavNode, NavNode>, Double>();

        // Создаем матрицу расстояний только с верхним треугольником
        for (int i = 0; i < nodes.size() - 1; ++i) {
            for (int j = i; j < nodes.size(); ++j) {
                var pair = new Pair<>(nodes.get(i), nodes.get(j));

                var firstPos = pair.getFirst().getPosition();
                var secondPos = pair.getSecond().getPosition();

                matrix.put(pair, firstPos.subtract(secondPos).length());
            }
        }

        return new GraphImpl(new HashSet<>(nodes), new DistanceMatrix(matrix));
    }
}
