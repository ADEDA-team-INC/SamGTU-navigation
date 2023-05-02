package org.adeda.samgtu_navigation.map.controller.admin;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
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
public class OutdoorObjectAdminController {
    private final OutdoorObjectService service;
    private final MapSchemasFactory schemasFactory;

    public OutdoorObjectAdminController(OutdoorObjectService service, MapSchemasFactory schemasFactory) {
        this.service = service;
        this.schemasFactory = schemasFactory;
    }

    @PostMapping
    public OutdoorObjectSchema createOutdoorObject(
        @RequestBody @Valid OutdoorObjectCreateSchema schema,
        HttpServletRequest request
    ) {
        return schemasFactory.getOutdoorObjectSchema(
            service.create(schema),
            SupportedLanguage.fromRequest(request)
        );
    }

    @PutMapping("/{id}")
    public OutdoorObjectSchema updateOutdoorObjectById(
        @PathVariable Integer id,
        @RequestBody @Valid OutdoorObjectCreateSchema schema,
        HttpServletRequest request
    ) throws NotFoundException {
        return schemasFactory.getOutdoorObjectSchema(
            service.updateById(id, schema),
            SupportedLanguage.fromRequest(request)
        );
    }

    @DeleteMapping("/{id}")
    public void deleteOutdoorObjectById(
        @PathVariable Integer id
    ) throws NotFoundException {
        service.deleteById(id);
    }
}
