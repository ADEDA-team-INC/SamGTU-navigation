package org.adeda.samgtu_navigation.navigation.service;

import org.adeda.samgtu_navigation.navigation.graph.Graph;

public interface GraphService {
    /**
     * Метод для поставки графа, соответствующему одному зданию на карте.
     * @param buildingId идентификатор здания
     * @return Новый объект графа, созданный с помощью `GraphFactory`, либо уже существующий.
     */
    Graph getGraphByBuildingId(Integer buildingId);
}
