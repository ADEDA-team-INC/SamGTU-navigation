package org.adeda.samgtu_navigation.navigation.service;

import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.navigation.schema.NavPointSchema;

import java.util.List;

public interface NavigationService {
    List<NavPointSchema> findPath(NavPointSchema startPoint, NavPointSchema endPoint) throws NotFoundException;
}
