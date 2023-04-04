package org.adeda.samgtu_navigation.map.service;

import org.adeda.samgtu_navigation.map.schema.MapBuildingSchema;
import org.adeda.samgtu_navigation.map.schema.MapDomainSchema;
import org.adeda.samgtu_navigation.map.schema.OutdoorObjectSchema;

import java.util.List;
import java.util.Optional;

public interface MapService {
    /**
     * Получить все здания на карте. Поддерживает пагинацию
     * @param size размер страницы
     * @param page номер страницы
     * @return Список всех зданий с учетом текущей страницы
     */
    List<MapBuildingSchema> getAllBuildings(int size, int page);

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

    /**
     * Получить все уличные объекты на карте. Поддерживает пагинацию
     * @param size размер страницы
     * @param page номер страницы
     * @return Список всех уличных объектов с учетом текущей страницы
     */
    List<OutdoorObjectSchema> getAllOutdoorObjects(int size, int page);
}
