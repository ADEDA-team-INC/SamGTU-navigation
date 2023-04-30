package org.adeda.samgtu_navigation.navigation.service.impl;

import org.adeda.samgtu_navigation.core.exception.InvalidFormatException;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.core.util.Vector2d;
import org.adeda.samgtu_navigation.map.repository.MapObjectRepository;
import org.adeda.samgtu_navigation.navigation.model.NavNode;
import org.adeda.samgtu_navigation.navigation.model.NodesConnection;
import org.adeda.samgtu_navigation.navigation.repository.NodeRepository;
import org.adeda.samgtu_navigation.navigation.repository.NodesConnectionRepository;
import org.adeda.samgtu_navigation.navigation.schema.NavNodeCreateSchema;
import org.adeda.samgtu_navigation.navigation.service.NodeService;

import java.util.*;
import java.util.stream.Collectors;

public class NodeServiceImpl implements NodeService {
    private final NodeRepository repository;
    private final NodesConnectionRepository connectionRepository;
    private final MapObjectRepository mapObjectRepository;

    public NodeServiceImpl(
        NodeRepository repository,
        NodesConnectionRepository connectionRepository,
        MapObjectRepository mapObjectRepository
    ) {
        this.repository = repository;
        this.connectionRepository = connectionRepository;
        this.mapObjectRepository = mapObjectRepository;
    }

    @Override
    public NavNode create(NavNodeCreateSchema schema) throws NotFoundException {
        var mapObject = mapObjectRepository.findById(schema.getMapObjectId()).orElse(null);
        if (mapObject == null) {
            throw new NotFoundException("MapObject with given id was not found");
        }

        var connections = getByIds(schema.getConnectionsIds());

        var node = new NavNode(
            mapObject,
            new Vector2d(schema.getPositionX(), schema.getPositionY()),
            new HashSet<>()
        );

        node = repository.save(node);

        var joins = new HashSet<NodesConnection>();
        for (var conn : connections) {
            var joinA = new NodesConnection(node, conn);
            var joinB = new NodesConnection(conn, node);

            joins.add(joinA);
            joins.add(joinB);

            node.getConnections().add(joinA);
            conn.getConnections().add(joinB);
        }

        repository.saveAll(connections);
        connectionRepository.saveAll(joins);

        return repository.save(node);
    }

    @Override
    public Optional<NavNode> getById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public NavNode update(Integer id, NavNodeCreateSchema schema) throws InvalidFormatException, NotFoundException {
        var node = repository.findById(id).orElse(null);
        if (node == null) {
            throw new NotFoundException("NavNode with given id was not found");
        }

        if (!schema.getMapObjectId().equals(node.getMapObject().getId())) {
            var mapObject = mapObjectRepository.findById(schema.getMapObjectId()).orElse(null);
            if (mapObject == null) {
                throw new NotFoundException("MapObject with given id was not found");
            }

            node.setMapObject(mapObject);
        }

        node.setPosition(new Vector2d(
            schema.getPositionX(), schema.getPositionY()
        ));

        var connections = getByIds(schema.getConnectionsIds());
        var joins = new ArrayList<>(node.getConnections());
        var invJoins = joins.stream().map(conn ->
            connectionRepository.findByNodeAAndNodeB(
                conn.getNodeB(), conn.getNodeA()
            ).orElseThrow()
        ).collect(Collectors.toCollection(ArrayList::new));

        for (int i = connections.size(); i < joins.size(); ++i) {
            connectionRepository.delete(joins.get(i));
            connectionRepository.delete(invJoins.get(i));
        }

        for (int i = 0; i < joins.size(); ++i) {
            joins.get(i).setNodeB(connections.get(i));
            invJoins.get(i).setNodeA(connections.get(i));
        }

        for (int i = joins.size(); i < connections.size(); ++i) {
            joins.add(new NodesConnection(node, connections.get(i)));
            invJoins.add(new NodesConnection(connections.get(i), node));
        }

        connectionRepository.saveAll(joins);
        connectionRepository.saveAll(invJoins);

        return repository.save(node);
    }

    @Override
    public void deleteById(Integer id) throws NotFoundException {
        var node = repository.findById(id).orElse(null);
        if (node == null) {
            throw new NotFoundException("NavNode with given id was not found");
        }

        for (var conn : node.getConnections()) {
            var invConn = connectionRepository.findByNodeAAndNodeB(
                conn.getNodeB(), conn.getNodeA()
            ).orElseThrow();
            connectionRepository.delete(conn);
            connectionRepository.delete(invConn);
        }

        repository.delete(node);
    }

    private List<NavNode> getByIds(List<Integer> ids) throws NotFoundException {
        var result = new LinkedList<NavNode>();
        for (var id : ids) {
            var node = repository.findById(id).orElse(null);
            if (node == null) {
                throw new NotFoundException("NavNode with given id was not found");
            }
            result.add(node);
        }
        return result;
    }
}
