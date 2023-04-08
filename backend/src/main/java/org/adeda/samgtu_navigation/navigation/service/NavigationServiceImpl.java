package org.adeda.samgtu_navigation.navigation.service;

import org.adeda.samgtu_navigation.core.exception.InvalidFormatException;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.map.model.MapObject;
import org.adeda.samgtu_navigation.map.repository.MapObjectRepository;
import org.adeda.samgtu_navigation.navigation.graph.GraphImpl;
import org.adeda.samgtu_navigation.navigation.model.NavNode;
import org.adeda.samgtu_navigation.navigation.schema.NavPointSchema;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NavigationServiceImpl implements NavigationService{

    MapObjectRepository mapObjectRepository;

    GraphService graphService;

    public NavigationServiceImpl(MapObjectRepository mapObjectRepository, GraphService graphService) {
        this.mapObjectRepository = mapObjectRepository;
        this.graphService = graphService;
    }

    @Override
    public List<NavPointSchema> findPath(List<NavPointSchema> points) throws NotFoundException, InvalidFormatException {
        List<MapObject> pointsMapObjects = points.stream().map(p -> mapObjectRepository.findByObjectId(p.getMapObjectId())).toList();

        GraphImpl graph = (GraphImpl) graphService.getGraphByBuildingId(
                pointsMapObjects.get(0).getDomain().getBuilding().getId()
        );

        //Проверка точек на принадлежность одному зданию
        for(int i = 1; i < points.size() - 1; i++){
            if(!pointsMapObjects.get(i).getDomain().getBuilding().getId().equals
                    (pointsMapObjects.get(0).getDomain().getBuilding().getId()))
                throw new InvalidFormatException("Points from different buildings");
        }

        List<NavNode> nodeList = points.stream().map(p -> findClosestNode(p, mapObjectRepository.findByObjectId(p.getMapObjectId()).getNodes().stream().toList())).toList();
        List<NavPointSchema> response = new LinkedList<>();

        //Прокладывание пути
        for (int i = 0; i < nodeList.size() - 1; i++){
            response.addAll(graph.findPath
                    (nodeList.get(i), nodeList.get(i + 1))
                    .stream().map(NavPointSchema::new).toList());

        }

        return response;
    }

    private NavNode findClosestNode(NavPointSchema point, List<NavNode> sameObjectNodes){
        if(sameObjectNodes.size() == 0)
            throw new InvalidFormatException("This object(s) does not exist");

        if(sameObjectNodes.size() == 1)
            return sameObjectNodes.get(0);

        //Поиск ближайшей точки
        NavNode favouriteNode = sameObjectNodes.get(0);
        for(int i = 1; i < sameObjectNodes.size(); i++){
            if(favouriteNode.getPosition().subtract(point.getPositionX(), point.getPositionY()).length()
                    >
                    sameObjectNodes.get(i).getPosition().subtract(point.getPositionX(), point.getPositionY()).length()){
                favouriteNode = sameObjectNodes.get(i);
            }
        }


        return favouriteNode;
    }
}
