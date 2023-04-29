package org.adeda.samgtu_navigation.navigation.controller;

import org.adeda.samgtu_navigation.core.exception.AlreadyExistsException;
import org.adeda.samgtu_navigation.core.exception.InvalidFormatException;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.map.model.MapObject;
import org.adeda.samgtu_navigation.map.service.MapDomainService;
import org.adeda.samgtu_navigation.map.service.MapObjectService;
import org.adeda.samgtu_navigation.navigation.model.NavNode;
import org.adeda.samgtu_navigation.navigation.schema.NavNodeCreateSchema;
import org.adeda.samgtu_navigation.navigation.schema.NavNodeSchema;
import org.adeda.samgtu_navigation.navigation.service.NodeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
@Validated
public class NodeAdminController {

    private final NodeService service;

    private final MapDomainService domainService;

    private final MapObjectService objectService;

    public NodeAdminController(NodeService service, MapDomainService domainService, MapObjectService objectService) {
        this.service = service;
        this.domainService = domainService;
        this.objectService = objectService;
    }

    @GetMapping("/node/{id}")
    public NavNodeSchema getNavNode(
        @PathVariable Integer id
    ) throws NotFoundException {
        var ONavNode = service.getById(id);
        if(ONavNode.isPresent()) {
            NavNode navNode = ONavNode.get();
            return new NavNodeSchema(navNode);
        }

        throw new NotFoundException("Node with this id is`t exist");
    }

    @GetMapping("/map/domain/{id}/nodes")
    public List<NavNodeSchema> getNodesByDomainId(
            @PathVariable Integer id
    ) throws NotFoundException {
            return domainService.getNodes(id).stream().map(NavNodeSchema::new).toList();
    }

    @GetMapping("/map/object/{id}/nodes")
    public List<NavNodeSchema> getNodesByObjectId(
            @PathVariable Integer id
    ) throws NotFoundException {
        Optional<MapObject> mapObject = objectService.getById(id);
        if(mapObject.isPresent()) {
            return mapObject.get().getNodes().stream().map(NavNodeSchema::new).toList();
        }

        throw new NotFoundException("Object with this id is`t exist");
    }

    @PostMapping("/node")
    public NavNodeSchema postNavNode(
        @RequestBody NavNodeCreateSchema createSchema
    ) throws InvalidFormatException, AlreadyExistsException {
        return new NavNodeSchema(service.create(createSchema));
    }

    @PutMapping("/node/{id}")
    public NavNodeSchema putNavNode(
        @PathVariable Integer id,
        @RequestBody NavNodeCreateSchema createSchema
    ) throws NotFoundException,InvalidFormatException {
        return new NavNodeSchema(service.update(id, createSchema));
    }

    @DeleteMapping("/node/{id}")
    public void deleteNavNode(
        @PathVariable Integer id
    ) throws NotFoundException {
        service.delete(id);
    }
}
