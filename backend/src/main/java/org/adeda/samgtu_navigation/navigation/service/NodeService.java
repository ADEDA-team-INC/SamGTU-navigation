package org.adeda.samgtu_navigation.navigation.service;

import org.adeda.samgtu_navigation.core.exception.InvalidFormatException;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.navigation.model.NavNode;
import org.adeda.samgtu_navigation.navigation.schema.NavNodeCreateSchema;

import java.util.Optional;

public interface NodeService {
    NavNode create(NavNodeCreateSchema schema) throws InvalidFormatException, NotFoundException;

    Optional<NavNode> getById(Integer id);

    NavNode update(Integer id, NavNodeCreateSchema schema) throws InvalidFormatException, NotFoundException;

    void deleteById(Integer id) throws NotFoundException;
}
