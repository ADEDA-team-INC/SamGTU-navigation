package org.adeda.samgtu_navigation.map.service;

import org.adeda.samgtu_navigation.map.schema.MapBuildingSchema;
import org.adeda.samgtu_navigation.map.schema.MapDomainSchema;

import java.util.Optional;

public interface MapService {
    /**
     * Получения объекта здания на карте
     * @param id идентификатор здания
     *
     * @return Объект здания `MapBuildingSchema`.
     */
    Optional<MapBuildingSchema> getBuildingById(Integer id);

    /**
     * Получения объекта пространства на карте
     * @param id идентификатор пространства
     * @return Объект пространства `MapDomainSchema`.
     */
    Optional<MapDomainSchema> getDomainById(Integer id);
}
