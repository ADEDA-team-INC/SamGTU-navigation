package org.adeda.samgtu_navigation.navigation.service;

import org.adeda.samgtu_navigation.core.exception.InvalidFormatException;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.navigation.graph.GraphImpl;
import org.adeda.samgtu_navigation.navigation.model.NavNode;
import org.adeda.samgtu_navigation.navigation.schema.NavPointSchema;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NavigationServiceImpl implements NavigationService{

    @Override
    public List<NavPointSchema> findPath(List<NavPointSchema> points) throws NotFoundException, InvalidFormatException {
        GraphImpl graph = (GraphImpl) new GraphServiceImpl().getGraphByBuildingId(points.get(0).getMapObjectId());

        if(points.size() < 2) throw new InvalidFormatException("Less than 2 navPointSchema are specified");

        //Проверка точек на принадлежность одному зданию
        for(int i = 1; i < points.size() - 1; i++){
            if(!points.get(i).getMapObjectId().equals(points.get(0).getMapObjectId())) throw new InvalidFormatException("Points from different buildings");
        }

        Set<NavNode> nodesSet = new HashSet<>();
        for(NavPointSchema point: points){
            nodesSet.add(findNode(point, graph));
        }

        //Проверка на расположение всех точек в одном месте
        if(nodesSet.size() <= 1){
            throw new InvalidFormatException("Pathfinding is not need");
        }

        List<NavPointSchema> response = new ArrayList<>();

        //Прокладывание пути
        for (int i = 0; i < nodesSet.size() - 1; i++){
            for(NavNode node: graph.findPath
                    (nodesSet.stream().toList().get(i),
                    nodesSet.stream().toList().get(i + 1)))
            {
                response.add(new NavPointSchema(node));
            }
        }

        return response;
    }

    private NavNode findNode(NavPointSchema point, GraphImpl graph){
        List<NavNode> sameBuildingNodes = new ArrayList<>();

        for(NavNode vert: graph.getNodes()){
            if(vert.getMapObject().getId().equals(point.getMapObjectId())) sameBuildingNodes.add(vert);
        }

        if(sameBuildingNodes.size() == 0)
            throw new InvalidFormatException("This object(s) does not exist");

        if(sameBuildingNodes.size() == 1)
            return sameBuildingNodes.get(0);

        //Поиск ближайшей точки
        NavNode favouriteNode = sameBuildingNodes.get(0);
        for(int i = 1; i < sameBuildingNodes.size(); i++){
            if(Math.abs(point.getPositionX() - favouriteNode.getPosition().getX()) + Math.abs(point.getPositionY() - favouriteNode.getPosition().getY())
                    >
               Math.abs(point.getPositionX() - sameBuildingNodes.get(i).getPosition().getX()) + Math.abs(point.getPositionY() - sameBuildingNodes.get(i).getPosition().getY())){
                favouriteNode = sameBuildingNodes.get(i);
            }
        }


        return favouriteNode;
    }
}
