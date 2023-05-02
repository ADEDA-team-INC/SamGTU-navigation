package org.adeda.samgtu_navigation.navigation.service.impl;

import org.adeda.samgtu_navigation.core.exception.InvalidFormatException;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.map.repository.MapObjectRepository;
import org.adeda.samgtu_navigation.navigation.model.NavNode;
import org.adeda.samgtu_navigation.navigation.schema.NavPointSchema;
import org.adeda.samgtu_navigation.navigation.service.GraphService;
import org.adeda.samgtu_navigation.navigation.service.NavigationService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NavigationServiceImpl implements NavigationService {
    private final MapObjectRepository mapObjectRepository;
    private final GraphService graphService;

    public NavigationServiceImpl(MapObjectRepository mapObjectRepository, GraphService graphService) {
        this.mapObjectRepository = mapObjectRepository;
        this.graphService = graphService;
    }

    @Override
    public List<NavPointSchema> findPath(List<NavPointSchema> points) throws NotFoundException, InvalidFormatException {
        var nodes = points.stream().map(this::findClosestNode).toList();
        
        var graph = graphService.getByBuildingId(
            nodes.get(0).getMapObject().getDomain().getBuilding().getId()
        );

        var path = new LinkedList<NavPointSchema>();
        for (int i = 0; i < nodes.size() - 1; ++i) {
            path.add(points.get(i));
            path.addAll(
                graph.findPath(
                    nodes.get(i), nodes.get(i + 1)
                ).stream().map(NavPointSchema::new).toList()
            );
        }
        path.add(points.get(points.size() - 1));

        return path;
    }

    private NavNode findClosestNode(NavPointSchema point) {
        var pos = point.getPosition();

        var mapObject = mapObjectRepository.findById(point.getMapObjectId()).orElse(null);
        if (mapObject == null) {
            throw new NotFoundException("MapObject with given id doesn't exist");
        }
        if (!mapObject.containsPoint(pos)) {
            throw new InvalidFormatException("NavPoint doesn't belong to given MapObject");
        }

        var closestNode = mapObject.getNodes().stream().min(
            Comparator.comparingDouble(n -> n.getPosition().subtract(pos).length())
        );

        if (closestNode.isEmpty()) {
            throw new NotFoundException("Unable to find closest node for given NavPoint");
        }

        return closestNode.get();
    }
}
