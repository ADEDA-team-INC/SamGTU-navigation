package org.adeda.samgtu_navigation.navigation.controller;

import org.adeda.samgtu_navigation.core.exception.InvalidFormatException;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.navigation.schema.NavPointSchema;

import java.util.List;

public interface NavigationController {
    List<NavPointSchema> findPath(List<NavPointSchema> points) throws NotFoundException, InvalidFormatException;
}
