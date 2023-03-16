package org.adeda.samgtu_navigation.navigation.controller;

import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.navigation.schema.NavPointSchema;
import org.adeda.samgtu_navigation.navigation.schema.NavigationRequest;

import java.util.List;

public interface NavigationController {
    List<NavPointSchema> findPath(NavigationRequest schema) throws NotFoundException;
}
