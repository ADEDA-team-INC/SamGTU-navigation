package org.adeda.samgtu_navigation.navigation.service;

import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.navigation.graph.Graph;

public interface GraphService {
    /**
     * Метод для поставки графа, соответствующему одному зданию на карте.
     * @param id идентификатор здания
     * @return Новый объект графа, созданный с помощью `GraphFactory`, либо уже существующий.
     * @throws NotFoundException здания с `id` не существует
     */
    Graph getByBuildingId(Integer id) throws NotFoundException;
}
