package org.adeda.samgtu_navigation.map.service;

import org.adeda.samgtu_navigation.map.model.MapBuilding;
import org.adeda.samgtu_navigation.map.model.MapDomain;
import org.adeda.samgtu_navigation.map.model.MapObject;
import org.adeda.samgtu_navigation.map.model.OutdoorObject;
import org.adeda.samgtu_navigation.map.schema.MapSearchResult;

import java.util.List;
import java.util.Optional;

public interface MapService {
    /**
     * Получить все здания на карте. Поддерживает пагинацию
     * @param size размер страницы
     * @param page номер страницы
     * @return Список всех зданий с учетом текущей страницы
     */
    List<MapBuilding> getBuildings(int size, int page);

    /**
     * Получения объекта здания на карте
     * @param id идентификатор здания
     *
     * @return Объект здания `MapBuilding`.
     */
    Optional<MapBuilding> getBuildingById(Integer id);

    /**
     * Получения объекта пространства на карте
     * @param id идентификатор пространства
     * @return Объект пространства `MapDomain`.
     */
    Optional<MapDomain> getDomainById(Integer id);

    /**
     * Получение объекта на карте по его идентификатору
     * @param id идентификатор объекта
     * @return Объект на карте `MapObject`.
     */
    Optional<MapObject> getObjectById(Integer id);

    /**
     * Получить все уличные объекты на карте. Поддерживает пагинацию
     * @param size размер страницы
     * @param page номер страницы
     * @return Список всех уличных объектов с учетом текущей страницы
     */
    List<OutdoorObject> getOutdoorObjects(int size, int page);

    /**
     * Метод поиска сущностей на карте по запросу. Поиск идет по вхождению запроса в отображаемое имя или описание
     * объектов.
     * @param query текстовая строка запроса
     * @return Результат поиска для каждого отдельного вида сущности (MapBuilding, MapObject, OutdoorObject)
     */
    MapSearchResult search(String query);
}
