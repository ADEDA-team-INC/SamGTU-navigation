package org.adeda.samgtu_navigation.map.controller.admin;

import jakarta.servlet.http.HttpServletRequest;
import org.adeda.samgtu_navigation.core.exception.AlreadyExistsException;
import org.adeda.samgtu_navigation.core.exception.InvalidFormatException;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.localization.enums.SupportedLanguage;
import org.adeda.samgtu_navigation.map.schema.outdoor_object.OutdoorObjectCreateSchema;
import org.adeda.samgtu_navigation.map.schema.outdoor_object.OutdoorObjectSchema;
import org.adeda.samgtu_navigation.map.service.MapSchemasFactory;
import org.adeda.samgtu_navigation.map.service.OutdoorObjectService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/map/outdoor_object")
@Validated
public class OutdoorObjectAdmController {

    private final OutdoorObjectService service;

    private final MapSchemasFactory schemasFactory;

    public OutdoorObjectAdmController(OutdoorObjectService service, MapSchemasFactory schemasFactory) {
        this.service = service;
        this.schemasFactory = schemasFactory;
    }

    @PostMapping
    public OutdoorObjectSchema postOutdoorObject(
        @RequestBody OutdoorObjectCreateSchema createSchema,
        HttpServletRequest request
    ) throws InvalidFormatException, AlreadyExistsException {
        return schemasFactory.getOutdoorObjectSchema(service.create(createSchema),
                SupportedLanguage.fromRequest(request));
    }

    @PutMapping("/{id}")
    public OutdoorObjectSchema putOutdoorObject(
        @PathVariable Integer id,
        @RequestBody OutdoorObjectCreateSchema createSchema,
        HttpServletRequest request
    ) throws NotFoundException, InvalidFormatException {
        return schemasFactory.getOutdoorObjectSchema(service.updateById(id, createSchema),
                SupportedLanguage.fromRequest(request));
    }

    @DeleteMapping("/{id}")
    public void deleteOutdoorObject(
        @PathVariable Integer id
    ) throws NotFoundException {
        service.deleteById(id);
    }
}
