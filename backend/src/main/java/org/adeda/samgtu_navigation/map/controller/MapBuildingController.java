package org.adeda.samgtu_navigation.map.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.localization.enums.SupportedLanguage;
import org.adeda.samgtu_navigation.map.schema.map_building.MapBuildingInfo;
import org.adeda.samgtu_navigation.map.schema.map_building.MapBuildingSchema;
import org.adeda.samgtu_navigation.map.service.MapBuildingService;
import org.adeda.samgtu_navigation.map.service.MapSchemasFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/map")
@Validated
public class MapBuildingController {
    private final MapBuildingService service;
    private final MapSchemasFactory schemasFactory;

    public MapBuildingController(MapBuildingService service, MapSchemasFactory schemasFactory) {
        this.service = service;
        this.schemasFactory = schemasFactory;
    }

    @GetMapping("/buildings")
    public List<MapBuildingInfo> getMapBuildings(
        @RequestParam(defaultValue = "10") @NotNull @Min(1) Integer size,
        @RequestParam(defaultValue = "0") @NotNull @Min(0) Integer page,
        HttpServletRequest request
    ) {
        var language = SupportedLanguage.fromRequest(request);
        return service.getAll(size, page).stream().map(
            b -> schemasFactory.getBuildingInfo(b, language)
        ).toList();
    }

    @GetMapping("/building/{id}")
    public MapBuildingSchema getMapBuildingById(
        @PathVariable Integer id,
        HttpServletRequest request
    ) throws NotFoundException {
        return service.getById(id).map(
            b -> schemasFactory.getBuildingSchema(b, SupportedLanguage.fromRequest(request))
        ).orElseThrow(
            () -> new NotFoundException("MapBuilding with given id was not found")
        );
    }
}
