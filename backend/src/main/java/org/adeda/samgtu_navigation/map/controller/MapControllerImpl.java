package org.adeda.samgtu_navigation.map.controller;

import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.map.schema.MapBuildingSchema;
import org.adeda.samgtu_navigation.map.schema.MapDomainSchema;
import org.adeda.samgtu_navigation.map.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
    path = "/map",
    produces = MimeTypeUtils.APPLICATION_JSON_VALUE
)
public class MapControllerImpl implements MapController {
    private final MapService service;

    public MapControllerImpl(MapService service) {
        this.service = service;
    }

    @Override
    @GetMapping(path = "/building/{id}")
    public MapBuildingSchema getMapBuildingById(
        @PathVariable Integer id
    ) throws NotFoundException {
        var building = service.getBuildingById(id);
        if (building.isEmpty()) {
            throw new NotFoundException();
        }

        return building.get();
    }

    @Override
    @GetMapping(path = "/domain/{id}")
    public MapDomainSchema getMapDomainById(
        @PathVariable Integer id
    ) throws NotFoundException {
        var domain = service.getDomainById(id);
        if (domain.isEmpty()) {
            throw new NotFoundException();
        }

        return domain.get();
    }
}
