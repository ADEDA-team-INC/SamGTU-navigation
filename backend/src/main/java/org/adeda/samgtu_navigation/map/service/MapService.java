package org.adeda.samgtu_navigation.map.service;

import org.adeda.samgtu_navigation.map.schema.MapSearchResult;

public interface MapService {
    /**
     * Метод поиска сущностей на карте по запросу. Поиск идет по вхождению запроса в отображаемое имя или описание
     * объектов.
     * @param query текстовая строка запроса
     * @return Результат поиска для каждого отдельного вида сущности (MapBuilding, MapObject, OutdoorObject)
     */
    MapSearchResult search(String query);
}
