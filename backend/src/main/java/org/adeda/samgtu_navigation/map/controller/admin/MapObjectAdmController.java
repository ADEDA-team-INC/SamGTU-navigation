package org.adeda.samgtu_navigation.map.controller.admin;

import jakarta.servlet.http.HttpServletRequest;
import org.adeda.samgtu_navigation.core.exception.AlreadyExistsException;
import org.adeda.samgtu_navigation.core.exception.InvalidFormatException;
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
public class MapObjectAdmController {

    private final MapObjectService service;

    private final MapSchemasFactory schemasFactory;

    public MapObjectAdmController(MapObjectService service, MapSchemasFactory schemasFactory) {
        this.service = service;
        this.schemasFactory = schemasFactory;
    }

    @PostMapping("/domain/{id}/object")
    public MapObjectSchema postMapObject(
        @PathVariable Integer id,
        @RequestBody MapObjectCreateSchema createSchema,
        HttpServletRequest request
    ) throws InvalidFormatException, AlreadyExistsException {
        return schemasFactory.getObjectSchema(service.create(id, createSchema),
                SupportedLanguage.fromRequest(request));
    }

    @PutMapping("/object/{id}")
    public MapObjectSchema putMapObject(
        @PathVariable Integer id,
        @RequestBody MapObjectCreateSchema createSchema,
        HttpServletRequest request
    ) throws NotFoundException, InvalidFormatException {
        return schemasFactory.getObjectSchema(service.updateById(id, createSchema),
                SupportedLanguage.fromRequest(request));
    }

    @DeleteMapping("/object/{id}")
    public void deleteMapObject(
        @PathVariable Integer id
    ) throws NotFoundException {
        service.deleteById(id);
    }
}
