package org.adeda.samgtu_navigation.map.controller.admin;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.localization.enums.SupportedLanguage;
import org.adeda.samgtu_navigation.map.schema.map_building.MapBuildingCreateSchema;
import org.adeda.samgtu_navigation.map.schema.map_building.MapBuildingSchema;
import org.adeda.samgtu_navigation.map.service.MapBuildingService;
import org.adeda.samgtu_navigation.map.service.MapSchemasFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/map")
@Validated
public class MapBuildingAdminController {
    private final MapBuildingService service;
    private final MapSchemasFactory schemasFactory;

    public MapBuildingAdminController(MapBuildingService service, MapSchemasFactory schemasFactory) {
        this.service = service;
        this.schemasFactory = schemasFactory;
    }

    @PostMapping("/building")
    public MapBuildingSchema createMapBuilding(
        @RequestBody @Valid MapBuildingCreateSchema schema,
        HttpServletRequest request
    ) {
        return schemasFactory.getBuildingSchema(
            service.create(schema),
            SupportedLanguage.fromRequest(request)
        );
    }

    @PutMapping("/building/{id}")
    public MapBuildingSchema updateMapBuildingById(
        @PathVariable Integer id,
        @RequestBody @Valid MapBuildingCreateSchema schema,
        HttpServletRequest request
    ) throws NotFoundException {
        return schemasFactory.getBuildingSchema(
            service.updateById(id, schema),
            SupportedLanguage.fromRequest(request)
        );
    }

    @DeleteMapping("/building/{id}")
    public void deleteMapBuildingById(
        @PathVariable Integer id
    ) throws NotFoundException {
        service.deleteById(id);
    }
}
