package org.adeda.samgtu_navigation.map.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.Min;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.localization.enums.SupportedLanguage;
import org.adeda.samgtu_navigation.map.schema.map_building.MapBuildingSchema;
import org.adeda.samgtu_navigation.map.schema.map_domain.MapDomainSchema;
import org.adeda.samgtu_navigation.map.schema.map_object.DetailedMapObject;
import org.adeda.samgtu_navigation.map.schema.outdoor_object.OutdoorObjectSchema;
import org.adeda.samgtu_navigation.map.service.MapSchemasFactory;
import org.adeda.samgtu_navigation.map.service.MapService;
import org.springframework.util.MimeTypeUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.RequestContextUtils;

import java.util.List;

@RestController
@RequestMapping(
    path = "/map",
    produces = MimeTypeUtils.APPLICATION_JSON_VALUE
)
@Validated
public class MapControllerImpl {
    private final MapService service;
    private final MapSchemasFactory schemasFactory;

    public MapControllerImpl(MapService service, MapSchemasFactory schemasFactory) {
        this.service = service;
        this.schemasFactory = schemasFactory;
    }

    @GetMapping(path = "/buildings")
    public List<MapBuildingSchema> getMapBuildings(
        @RequestParam(defaultValue = "10") @Min(1) int size,
        @RequestParam(defaultValue = "0") @Min(0) int page,
        HttpServletRequest request
    ) {
        var language = SupportedLanguage.byLocale(RequestContextUtils.getLocale(request));

        return service.getBuildings(size, page).stream().map(
            b -> schemasFactory.getBuildingSchema(b, language)
        ).toList();
    }

    @GetMapping(path = "/building/{id}")
    public MapBuildingSchema getMapBuildingById(
        @PathVariable Integer id,
        HttpServletRequest request
    ) throws NotFoundException {
        var language = SupportedLanguage.byLocale(RequestContextUtils.getLocale(request));

        var building = service.getBuildingById(id);
        if (building.isEmpty()) {
            throw new NotFoundException("MapBuilding with given id doesn't exist");
        }

        return schemasFactory.getBuildingSchema(building.get(), language);
    }

    @GetMapping(path = "/domain/{id}")
    public MapDomainSchema getMapDomainById(
        @PathVariable Integer id,
        HttpServletRequest request
    ) throws NotFoundException {
        var language = SupportedLanguage.byLocale(RequestContextUtils.getLocale(request));

        var domain = service.getDomainById(id);
        if (domain.isEmpty()) {
            throw new NotFoundException("MapDomain with given id doesn't exist");
        }

        return schemasFactory.getDomainSchema(domain.get(), language);
    }

    @GetMapping(path = "/object/{id}")
    public DetailedMapObject getMapObjectById(
        @PathVariable Integer id,
        HttpServletRequest request
    ) {
        var language = SupportedLanguage.byLocale(RequestContextUtils.getLocale(request));

        var mapObject = service.getObjectById(id);
        if (mapObject.isEmpty()) {
            throw new NotFoundException("MapDomain with given id doesn't exist");
        }

        return schemasFactory.getDetailedMapObject(mapObject.get(), language);
    }

    @GetMapping(path = "/outdoor_objects")
    public List<OutdoorObjectSchema> getOutdoorObjects(
        @RequestParam(defaultValue = "10") @Min(1) int size,
        @RequestParam(defaultValue = "0") @Min(0) int page,
        HttpServletRequest request
    ) {
        var language = SupportedLanguage.byLocale(RequestContextUtils.getLocale(request));

        return service.getOutdoorObjects(size, page).stream().map(
            o -> schemasFactory.getOutdoorObjectSchema(o, language)
        ).toList();
    }
}
