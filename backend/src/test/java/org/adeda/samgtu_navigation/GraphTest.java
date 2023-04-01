package org.adeda.samgtu_navigation;

import org.adeda.samgtu_navigation.core.util.Vector2d;
import org.adeda.samgtu_navigation.navigation.graph.Graph;
import org.adeda.samgtu_navigation.navigation.graph.GraphFactory;
import org.adeda.samgtu_navigation.navigation.model.NavNode;
import org.adeda.samgtu_navigation.navigation.model.NodesConnection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GraphTest {

    @Test
    public void GraphFactoryTest(){
        NavNode node1 = new NavNode();
        NavNode node2 = new NavNode();
        Vector2d vector1 = new Vector2d(0, 0);
        Vector2d vector2 = new Vector2d(4, 10);
        node1.setPosition(vector1);
        node2.setPosition(vector2);
        node1.setConnections(Set.of(new NodesConnection(node1, node2)));
        node2.setConnections(Set.of(new NodesConnection(node2, node1)));

        //Чтобы работал в NavNode сеттер нада сделать публичным
        //node1.setId(0);
        //node2.setId(1);

        List<NavNode> nodeList = new ArrayList<>();
        nodeList.add(node1);
        nodeList.add(node2);
        Graph graph = new GraphFactory().createGraph(nodeList);

        System.out.println(graph);
    }
}
