package org.adeda.samgtu_navigation.navigation.service;

import org.adeda.samgtu_navigation.navigation.graph.Graph;
import org.adeda.samgtu_navigation.navigation.model.NavNode;

import java.util.List;

public interface GraphFactory {
    /**
     * Метод создания нового графа. Внутри заранее просчитывает матрицу расстояний
     * для всех узлов.
     * @param nodes список узлов, по которым необходимо создать граф
     * @return Новый объект графа
     */
    Graph createGraph(List<NavNode> nodes);
}
