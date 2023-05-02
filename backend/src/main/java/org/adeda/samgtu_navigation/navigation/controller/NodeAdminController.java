package org.adeda.samgtu_navigation.navigation.controller;

import jakarta.validation.Valid;
import org.adeda.samgtu_navigation.core.exception.InvalidFormatException;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.map.service.MapDomainService;
import org.adeda.samgtu_navigation.map.service.MapObjectService;
import org.adeda.samgtu_navigation.navigation.schema.NavNodeCreateSchema;
import org.adeda.samgtu_navigation.navigation.schema.NavNodeSchema;
import org.adeda.samgtu_navigation.navigation.service.NodeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public NavNodeSchema getNodeById(
        @PathVariable Integer id
    ) throws NotFoundException {
        return service.getById(id).map(NavNodeSchema::new).orElseThrow(
            () -> new NotFoundException("Node with given id doesn't exist")
        );
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
        return objectService.getById(id).orElseThrow(
            () -> new NotFoundException("MapObject with given id doesn't exist")
        ).getNodes().stream().map(NavNodeSchema::new).toList();
    }

    @PostMapping("/node")
    public NavNodeSchema createNode(
        @RequestBody @Valid NavNodeCreateSchema schema
    ) throws InvalidFormatException, NotFoundException {
        return new NavNodeSchema(service.create(schema));
    }

    @PutMapping("/node/{id}")
    public NavNodeSchema updateNodeById(
        @PathVariable Integer id,
        @RequestBody @Valid NavNodeCreateSchema schema
    ) throws NotFoundException, InvalidFormatException {
        return new NavNodeSchema(service.update(id, schema));
    }

    @DeleteMapping("/node/{id}")
    public void deleteNodeById(
        @PathVariable Integer id
    ) throws NotFoundException {
        service.deleteById(id);
    }
}
