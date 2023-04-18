package org.adeda.samgtu_navigation.map.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.localization.enums.SupportedLanguage;
import org.adeda.samgtu_navigation.map.schema.map_object.DetailedMapObject;
import org.adeda.samgtu_navigation.map.service.MapObjectService;
import org.adeda.samgtu_navigation.map.service.MapSchemasFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/map/object")
@Validated
public class MapObjectController {
    private final MapObjectService service;
    private final MapSchemasFactory schemasFactory;

    public MapObjectController(MapObjectService service, MapSchemasFactory schemasFactory) {
        this.service = service;
        this.schemasFactory = schemasFactory;
    }

    @GetMapping("/{id}")
    public DetailedMapObject getMapObjectById(
        @PathVariable Integer id,
        HttpServletRequest request
    ) throws NotFoundException {
        return service.getById(id).map(
            o -> schemasFactory.getDetailedMapObject(o, SupportedLanguage.fromRequest(request))
        ).orElseThrow(
            () -> new NotFoundException("MapObject with given id was not found")
        );
    }
}
