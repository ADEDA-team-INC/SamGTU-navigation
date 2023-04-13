package org.adeda.samgtu_navigation.map.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.Min;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.map.schema.MapBuildingSchema;
import org.adeda.samgtu_navigation.map.schema.MapDomainSchema;
import org.adeda.samgtu_navigation.map.schema.OutdoorObjectSchema;
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

    public MapControllerImpl(MapService service) {
        this.service = service;
    }

    @GetMapping(path = "/buildings")
    public List<MapBuildingSchema> getAllMapBuildings(
        @RequestParam(defaultValue = "10") @Min(1) int size,
        @RequestParam(defaultValue = "0") @Min(0) int page
    ) {
        return service.getAllBuildings(size, page);
    }

    @GetMapping(path = "/building/{id}")
    public MapBuildingSchema getMapBuildingById(
        @PathVariable Integer id
    ) throws NotFoundException {
        var building = service.getBuildingById(id);
        if (building.isEmpty()) {
            throw new NotFoundException("MapBuilding with given id doesn't exist");
        }

        return building.get();
    }

    @GetMapping(path = "/domain/{id}")
    public MapDomainSchema getMapDomainById(
        @PathVariable Integer id
    ) throws NotFoundException {
        var domain = service.getDomainById(id);
        if (domain.isEmpty()) {
            throw new NotFoundException("MapDomain with given id doesn't exist");
        }

        return domain.get();
    }

    @GetMapping(path = "/outdoor_objects")
    public List<OutdoorObjectSchema> getAllOutdoorObjects(
        @RequestParam(defaultValue = "10") @Min(1) int size,
        @RequestParam(defaultValue = "0") @Min(0) int page
    ) {
        return service.getAllOutdoorObjects(size, page);
    }
}
