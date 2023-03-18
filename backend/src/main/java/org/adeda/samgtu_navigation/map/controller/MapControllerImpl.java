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
public class MapControllerImpl implements MapController{

    private MapService mapService;

    @Autowired
    public void setService(MapService mapService){
        this.mapService = mapService;
    }

    @Override
    @GetMapping(path = "/building/{id}")
    public MapBuildingSchema getMapBuildingById(@PathVariable Integer id) throws NotFoundException {
        return mapService.getBuildingById(id);
    }

    @Override
    @GetMapping(path = "/domain/{id}")
    public MapDomainSchema getMapDomainById(@PathVariable Integer id) throws NotFoundException {
        return mapService.getDomainById(id);
    }
}
