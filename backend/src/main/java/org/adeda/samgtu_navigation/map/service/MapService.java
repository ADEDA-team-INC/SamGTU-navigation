package org.adeda.samgtu_navigation.map.service;

import org.adeda.samgtu_navigation.map.model.MapBuilding;
import org.adeda.samgtu_navigation.map.model.MapDomain;
import org.adeda.samgtu_navigation.map.model.OutdoorObject;

import java.util.List;
import java.util.Optional;

public interface MapService {
    /**
     * Получить все здания на карте. Поддерживает пагинацию
     * @param size размер страницы
     * @param page номер страницы
     * @return Список всех зданий с учетом текущей страницы
     */
    List<MapBuilding> getAllBuildings(int size, int page);

    /**
     * Получения объекта здания на карте
     * @param id идентификатор здания
     *
     * @return Объект здания `MapBuildingSchema`.
     */
    Optional<MapBuilding> getBuildingById(Integer id);

    /**
     * Получения объекта пространства на карте
     * @param id идентификатор пространства
     * @return Объект пространства `MapDomainSchema`.
     */
    Optional<MapDomain> getDomainById(Integer id);

    /**
     * Получить все уличные объекты на карте. Поддерживает пагинацию
     * @param size размер страницы
     * @param page номер страницы
     * @return Список всех уличных объектов с учетом текущей страницы
     */
    List<OutdoorObject> getAllOutdoorObjects(int size, int page);
}
