package org.adeda.samgtu_navigation.navigation.service;

import org.adeda.samgtu_navigation.core.exception.InvalidFormatException;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.navigation.model.NavNode;
import org.adeda.samgtu_navigation.navigation.graph.Graph;

import java.util.List;

public interface GraphService {
    Graph getGraphByBuildingId(Integer id) throws NotFoundException;

    Graph buildGraph(List<NavNode> nodes) throws InvalidFormatException;
}
