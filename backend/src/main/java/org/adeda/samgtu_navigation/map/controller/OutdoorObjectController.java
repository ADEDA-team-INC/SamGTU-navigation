package org.adeda.samgtu_navigation.map.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.localization.enums.SupportedLanguage;
import org.adeda.samgtu_navigation.map.enums.OutdoorObjectType;
import org.adeda.samgtu_navigation.map.schema.outdoor_object.OutdoorObjectSchema;
import org.adeda.samgtu_navigation.map.service.MapSchemasFactory;
import org.adeda.samgtu_navigation.map.service.OutdoorObjectService;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/map")
public class OutdoorObjectController {
    private final OutdoorObjectService service;
    private final MapSchemasFactory schemasFactory;

    public OutdoorObjectController(OutdoorObjectService service, MapSchemasFactory schemasFactory) {
        this.service = service;
        this.schemasFactory = schemasFactory;
    }

    @GetMapping("/outdoor_objects")
    public List<OutdoorObjectSchema> getOutdoorObjects(
        @RequestParam(required = false) OutdoorObjectType type,
        @RequestParam(defaultValue = "10") @NotNull @Min(1) Integer size,
        @RequestParam(defaultValue = "0") @NotNull @Min(0) Integer page,
        HttpServletRequest request
    ) throws NotFoundException {
        var language = SupportedLanguage.fromRequest(request);
        return service.getAll(type, PageRequest.of(page, size)).stream().map(
            o -> schemasFactory.getOutdoorObjectSchema(o, language)
        ).toList();
    }

    @GetMapping("/outdoor_object/{id}")
    public OutdoorObjectSchema getOutdoorObjectById(
        @PathVariable @NotNull Integer id,
        HttpServletRequest request
    ) throws NotFoundException {
        return service.getById(id).map(
            o -> schemasFactory.getOutdoorObjectSchema(o, SupportedLanguage.fromRequest(request))
        ).orElseThrow(
            () -> new NotFoundException("OutdoorObject with given id was not found")
        );
    }
}
