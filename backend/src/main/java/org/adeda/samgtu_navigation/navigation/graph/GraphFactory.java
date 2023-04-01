package org.adeda.samgtu_navigation.navigation.graph;

import org.adeda.samgtu_navigation.core.util.Pair;
import org.adeda.samgtu_navigation.navigation.model.NavNode;
import org.adeda.samgtu_navigation.navigation.model.NodesConnection;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
public class GraphFactory {
    /**
     * Метод создания нового графа. Внутри заранее просчитывает матрицу расстояний
     * для связанных узлов. При этом, матрица расстояний НЕ содержит в себе
     * повторяющихся значений.
     * @param nodes список узлов, по которым необходимо создать граф
     * @return Новый объект графа
     */
    public Graph createGraph(List<NavNode> nodes) {
        DistanceMatrix distances = new DistanceMatrix();

        for(NavNode node: nodes){
            var connections = node.getConnections();
            for(NodesConnection connection: connections){
                Pair<NavNode, NavNode> pair = new Pair<>(connection.getNodeA(), connection.getNodeB());
                if(!distances.isEmpty()){
                    boolean isExists = false;

                    for(Pair<NavNode, NavNode> conPair: distances.keySet()){
                        if (conPair.equals(pair)) {
                            isExists = true;
                            break;
                        }
                    }

                    if(!isExists) distances.put(pair, calcDist(pair));
                } else {
                    distances.put(pair, calcDist(pair));
                }
            }
        }

        return new GraphImpl(new HashSet<NavNode>(nodes), distances);
    }

    //Рассчитывает Евклидово растояние между двумя точками
    private double calcDist(Pair<NavNode, NavNode> nodes){
        var a = nodes.getFirst().getPosition();
        var b = nodes.getSecond().getPosition();

        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2)
                + Math.pow(a.getY() - b.getY(), 2));
    }
}
