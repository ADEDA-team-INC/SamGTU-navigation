package org.adeda.samgtu_navigation.map.controller.admin;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.adeda.samgtu_navigation.core.exception.AlreadyExistsException;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.localization.enums.SupportedLanguage;
import org.adeda.samgtu_navigation.map.schema.map_domain.MapDomainCreateSchema;
import org.adeda.samgtu_navigation.map.schema.map_domain.MapDomainSchema;
import org.adeda.samgtu_navigation.map.service.MapDomainService;
import org.adeda.samgtu_navigation.map.service.MapSchemasFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/map")
@Validated
public class MapDomainAdminController {
    private final MapDomainService service;
    private final MapSchemasFactory schemasFactory;

    public MapDomainAdminController(MapDomainService service, MapSchemasFactory schemasFactory) {
        this.service = service;
        this.schemasFactory = schemasFactory;
    }

    @PostMapping("/building/{id}/domain")
    public MapDomainSchema createMapDomain(
        @PathVariable Integer id,
        @RequestBody @Valid MapDomainCreateSchema schema,
        HttpServletRequest request
    ) throws NotFoundException, AlreadyExistsException {
        return schemasFactory.getDomainSchema(
            service.create(id, schema),
            SupportedLanguage.fromRequest(request)
        );
    }

    @PutMapping("/domain/{id}")
    public MapDomainSchema updateMapDomainById(
        @PathVariable Integer id,
        @RequestBody @Valid MapDomainCreateSchema schema,
        HttpServletRequest request
    ) throws NotFoundException, AlreadyExistsException {
        return schemasFactory.getDomainSchema(
            service.updateById(id, schema),
            SupportedLanguage.fromRequest(request)
        );
    }

    @DeleteMapping("/domain/{id}")
    public void deleteMapDomainById(
        @PathVariable Integer id
    ) throws NotFoundException {
        service.deleteById(id);
    }
}
