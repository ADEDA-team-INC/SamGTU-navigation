package org.adeda.samgtu_navigation.navigation.service.impl;

import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.map.repository.MapBuildingRepository;
import org.adeda.samgtu_navigation.navigation.graph.Graph;
import org.adeda.samgtu_navigation.navigation.repository.NodeRepository;
import org.adeda.samgtu_navigation.navigation.service.GraphFactory;
import org.adeda.samgtu_navigation.navigation.service.GraphService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GraphServiceImpl implements GraphService {
    private final Map<Integer, Graph> graphByBuildingId;
    private final GraphFactory graphFactory;
    private final MapBuildingRepository buildingRepository;
    private final NodeRepository nodeRepository;

    public GraphServiceImpl(
        MapBuildingRepository buildingRepository,
        GraphFactory graphFactory,
        NodeRepository nodeRepository
    ) {
        this.graphByBuildingId = new HashMap<>();
        this.graphFactory = graphFactory;
        this.buildingRepository = buildingRepository;
        this.nodeRepository = nodeRepository;
    }

    @Override
    public Graph getByBuildingId(Integer id) {
        if (!graphByBuildingId.containsKey(id)) {
            if (!buildingRepository.existsById(id)) {
                throw new NotFoundException("MapBuilding with given id doesn't exist");
            }

            var nodes = nodeRepository.findByBuildingId(id);
            var graph = graphFactory.createGraph(nodes);

            graphByBuildingId.put(id, graph);
        }
        return graphByBuildingId.get(id);
    }
}
