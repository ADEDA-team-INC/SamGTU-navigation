package org.adeda.samgtu_navigation.navigation.controller;

import org.adeda.samgtu_navigation.core.exception.InvalidFormatException;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.navigation.schema.NavPointSchema;

import java.util.List;

public interface NavigationController {
    /**
     * REST API метод для поиска пути
     * @param points список точек, между которыми нужно найти путь.
     *               Должен содержать минимум 2 элемента
     * @return Список точек, соответствующих пути
     * @throws NotFoundException если объекты на карте, указанные в предоставленных точках,
     * не существуют.
     * @throws InvalidFormatException если позиция точки находится вне границ соответствующего объекта.
     * Если `points.size()` < 2. Если объекты находятся в разных зданиях
     * (TODO: Добавить функционал навигации между зданиями).
     */
    List<NavPointSchema> findPath(List<NavPointSchema> points) throws NotFoundException, InvalidFormatException;
}
