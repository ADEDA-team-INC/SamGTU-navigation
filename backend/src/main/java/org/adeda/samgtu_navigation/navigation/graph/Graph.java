package org.adeda.samgtu_navigation.navigation.graph;

import org.adeda.samgtu_navigation.core.exception.InvalidFormatException;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.navigation.model.NavNode;

import java.util.List;

public interface Graph {
    /**
     * Метод поиска пути между двумя узлами графа. Внутри использует алгортим A*
     * @param startNode узел начала пути
     * @param endNode узел конца пути
     * @return Список узлов, соответствующих найденному пути. В начале и конце
     * содержит `startNode` и `endNode` соответственно.
     * @throws NotFoundException если путь между узлами не найден
     * @throws InvalidFormatException если `startNode` или `endNode` не принадлежат текущему графу
     */
    List<NavNode> findPath(NavNode startNode, NavNode endNode) throws NotFoundException, InvalidFormatException;
}
