package org.adeda.samgtu_navigation.navigation.graph;

import org.springframework.stereotype.Component;

@Component
public class GraphSupplier {
    /**
     * Метод для поставки графа, соответствующему одному зданию на карте.
     * @param buildingId идентификатор здания
     * @return Новый объект графа, созданный с помощью `GraphFactory`, либо уже существующий.
     */
    public Graph getGraphByBuildingId(Integer buildingId) {
        throw new UnsupportedOperationException();
    }
}
