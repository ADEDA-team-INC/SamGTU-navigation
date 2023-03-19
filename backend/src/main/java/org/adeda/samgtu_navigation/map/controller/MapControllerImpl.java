package org.adeda.samgtu_navigation.map.controller;

import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.map.schema.MapBuildingSchema;
import org.adeda.samgtu_navigation.map.schema.MapDomainSchema;
import org.adeda.samgtu_navigation.map.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

//TODO: добавить валидацию
@RestController
@RequestMapping(
        path = "/map",
        produces = MimeTypeUtils.APPLICATION_JSON_VALUE
)
public class MapControllerImpl implements MapController {
    @Autowired
    private MapService mapService;

    @Override
    @GetMapping(path = "/building/{id}")
    public MapBuildingSchema getMapBuildingById(
        @PathVariable Integer id
    ) throws NotFoundException {
        var building = mapService.getBuildingById(id);
        if (building == null) {
            throw new NotFoundException();
        }

        return building;
    }

    @Override
    @GetMapping(path = "/domain/{id}")
    public MapDomainSchema getMapDomainById(
        @PathVariable Integer id
    ) throws NotFoundException {
        var domain = mapService.getDomainById(id);
        if (domain == null) {
            throw new NotFoundException();
        }

        return domain;
    }
}
