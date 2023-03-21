package org.adeda.samgtu_navigation.map.service;

import org.adeda.samgtu_navigation.map.schema.MapBuildingSchema;
import org.adeda.samgtu_navigation.map.schema.MapDomainSchema;

public interface MapService {
    /**
     * Получения объекта здания на карте
     * @param id идентификатор здания
     *
     * @return Объект здания `MapBuildingSchema` или `null`, если объект не найден.
     */
    MapBuildingSchema getBuildingById(Integer id);

    /**
     * Получения объекта пространства на карте
     * @param id идентификатор пространства
     * @return Объект пространства `MapDomainSchema` или `null`, если объект не найден.
     */
    MapDomainSchema getDomainById(Integer id);
}
