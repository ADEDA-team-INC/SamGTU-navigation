package org.adeda.samgtu_navigation.map.controller.admin;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.localization.enums.SupportedLanguage;
import org.adeda.samgtu_navigation.map.schema.map_object.MapObjectCreateSchema;
import org.adeda.samgtu_navigation.map.schema.map_object.MapObjectSchema;
import org.adeda.samgtu_navigation.map.service.MapObjectService;
import org.adeda.samgtu_navigation.map.service.MapSchemasFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/map")
@Validated
public class MapObjectAdminController {
    private final MapObjectService service;
    private final MapSchemasFactory schemasFactory;

    public MapObjectAdminController(MapObjectService service, MapSchemasFactory schemasFactory) {
        this.service = service;
        this.schemasFactory = schemasFactory;
    }

    @PostMapping("/domain/{id}/object")
    public MapObjectSchema createMapObject(
        @PathVariable Integer id,
        @RequestBody @Valid MapObjectCreateSchema schema,
        HttpServletRequest request
    ) throws NotFoundException {
        return schemasFactory.getObjectSchema(
            service.create(id, schema),
            SupportedLanguage.fromRequest(request)
        );
    }

    @PutMapping("/object/{id}")
    public MapObjectSchema updateMapObjectById(
        @PathVariable Integer id,
        @RequestBody @Valid MapObjectCreateSchema schema,
        HttpServletRequest request
    ) throws NotFoundException {
        return schemasFactory.getObjectSchema(
            service.updateById(id, schema),
            SupportedLanguage.fromRequest(request)
        );
    }

    @DeleteMapping("/object/{id}")
    public void deleteMapObjectById(
        @PathVariable Integer id
    ) throws NotFoundException {
        service.deleteById(id);
    }
}
