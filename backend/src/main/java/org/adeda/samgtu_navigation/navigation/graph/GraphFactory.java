package org.adeda.samgtu_navigation.navigation.graph;

import org.adeda.samgtu_navigation.navigation.model.NavNode;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GraphFactory {
    /**
     * Метод создания нового графа. Внутри заранее просчитывает матрицу расстояний
     * для связанных узлов.
     * @param nodes список узлов, по которым необходимо создать граф
     * @return Новый объект графа
     */
    public Graph createGraph(List<NavNode> nodes) {
        throw new UnsupportedOperationException();
    }
}
