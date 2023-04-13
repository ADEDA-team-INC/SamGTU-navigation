package org.adeda.samgtu_navigation.navigation.service;

import org.adeda.samgtu_navigation.core.util.Pair;
import org.adeda.samgtu_navigation.navigation.graph.DistanceMatrix;
import org.adeda.samgtu_navigation.navigation.graph.Graph;
import org.adeda.samgtu_navigation.navigation.graph.GraphImpl;
import org.adeda.samgtu_navigation.navigation.model.NavNode;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Component
public class GraphFactoryImpl implements GraphFactory {
    /**
     * Метод создания нового графа. Внутри заранее просчитывает матрицу расстояний
     * для всех узлов.
     * @param nodes список узлов, по которым необходимо создать граф
     * @return Новый объект графа
     */
    @Override
    public Graph createGraph(List<NavNode> nodes) {
        var matrix = new HashMap<Pair<NavNode, NavNode>, Double>();

        // Создаем матрицу расстояний только с верхним треугольником
        for (int i = 0; i < nodes.size() - 1; ++i) {
            for (int j = i + 1; j < nodes.size(); ++j) {
                var pair = new Pair<>(nodes.get(i), nodes.get(j));

                var firstPos = pair.getFirst().getPosition();
                var secondPos = pair.getSecond().getPosition();

                matrix.put(pair, firstPos.subtract(secondPos).length());
            }
        }

        return new GraphImpl(new HashSet<>(nodes), new DistanceMatrix(matrix));
    }
}
