package org.adeda.samgtu_navigation.map.controller.admin;

import jakarta.servlet.http.HttpServletRequest;
import org.adeda.samgtu_navigation.core.exception.AlreadyExistsException;
import org.adeda.samgtu_navigation.core.exception.InvalidFormatException;
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
public class MapBuildingAdmController {

    private final MapBuildingService service;
    private final MapSchemasFactory schemasFactory;

    public MapBuildingAdmController(MapBuildingService service, MapSchemasFactory schemasFactory) {
        this.service = service;
        this.schemasFactory = schemasFactory;
    }

    @PostMapping("/building")
    public MapBuildingSchema postMapBuilding(
        @RequestBody MapBuildingCreateSchema createSchema,
        HttpServletRequest request
    ) throws InvalidFormatException, AlreadyExistsException {
        return schemasFactory.getBuildingSchema(service.create(createSchema),
                SupportedLanguage.fromRequest(request));
    }

    @PutMapping("/building/{id}")
    public MapBuildingSchema putMapBuilding(
        @PathVariable Integer id,
        @RequestBody MapBuildingCreateSchema createSchema,
        HttpServletRequest request
    ) throws NotFoundException, InvalidFormatException {
        return schemasFactory.getBuildingSchema(service.updateById(id, createSchema),
                SupportedLanguage.fromRequest(request));
    }

    @DeleteMapping("/building/{id}")
    public void deleteMapBuilding(
        @PathVariable Integer id
    ) throws NotFoundException {
        service.deleteById(id);
    }
}
