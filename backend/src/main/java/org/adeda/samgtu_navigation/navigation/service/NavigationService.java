package org.adeda.samgtu_navigation.navigation.service;

import org.adeda.samgtu_navigation.core.exception.InvalidFormatException;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.navigation.schema.NavPointSchema;

import java.util.List;

public interface NavigationService {
    /**
     * Метод поиска пути между заданными точками
     * @param points список точек, между которыми нужно найти путь.
     *               Должен содержать минимум 2 элемента.
     * @return Список найденных точек
     * @throws NotFoundException если позиция точки не принадлежат предоставленному объекту на карте `mapObjectId`
     * или путь между ними не существует.
     * @throws InvalidFormatException если `points` содержит меньше 2 элементов
     */
    List<NavPointSchema> findPath(List<NavPointSchema> points) throws NotFoundException, InvalidFormatException;
}
