package org.adeda.samgtu_navigation.map.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.localization.enums.SupportedLanguage;
import org.adeda.samgtu_navigation.map.schema.map_domain.MapDomainSchema;
import org.adeda.samgtu_navigation.map.service.MapDomainService;
import org.adeda.samgtu_navigation.map.service.MapSchemasFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/map/domain")
@Validated
public class MapDomainController {
    private final MapDomainService service;
    private final MapSchemasFactory schemasFactory;

    public MapDomainController(MapDomainService service, MapSchemasFactory schemasFactory) {
        this.service = service;
        this.schemasFactory = schemasFactory;
    }

    @GetMapping("/{id}")
    public MapDomainSchema getMapDomainById(
        @PathVariable Integer id,
        HttpServletRequest request
    ) throws NotFoundException {
        return service.getById(id).map(
            d -> schemasFactory.getDomainSchema(d, SupportedLanguage.fromRequest(request))
        ).orElseThrow(
            () -> new NotFoundException("MapDomain with given id was not found")
        );
    }
}
