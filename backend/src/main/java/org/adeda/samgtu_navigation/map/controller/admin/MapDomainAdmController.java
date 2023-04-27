package org.adeda.samgtu_navigation.map.controller.admin;

import jakarta.servlet.http.HttpServletRequest;
import org.adeda.samgtu_navigation.core.exception.InvalidFormatException;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.localization.enums.SupportedLanguage;
import org.adeda.samgtu_navigation.map.schema.map_domain.MapDomainCreateSchema;
import org.adeda.samgtu_navigation.map.schema.map_domain.MapDomainSchema;
import org.adeda.samgtu_navigation.map.service.MapBuildingService;
import org.adeda.samgtu_navigation.map.service.MapDomainService;
import org.adeda.samgtu_navigation.map.service.MapSchemasFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/map")
@Validated
public class MapDomainAdmController {
    private final MapDomainService service;
    private final MapSchemasFactory schemasFactory;

    public MapDomainAdmController(MapDomainService service, MapSchemasFactory schemasFactory) {
        this.service = service;
        this.schemasFactory = schemasFactory;
    }

    @PostMapping("/building/{id}/domain")
    public MapDomainSchema postMapDomain(
        @PathVariable Integer id,
        @RequestBody MapDomainCreateSchema createSchema,
        HttpServletRequest request
    ) throws NotFoundException, InvalidFormatException {
        return schemasFactory.getDomainSchema(service.create(id, createSchema),
                SupportedLanguage.fromRequest(request));
    }

    @PutMapping("/domain/{id}")
    public MapDomainSchema putMapDomain(
        @PathVariable Integer id,
        @RequestBody MapDomainCreateSchema createSchema,
        HttpServletRequest request
    ) throws NotFoundException, InvalidFormatException {
        return schemasFactory.getDomainSchema(service.updateById(id, createSchema),
                SupportedLanguage.fromRequest(request));
    }

    @DeleteMapping("/domain/{id}")
    public void deleteMapDomain(
        @PathVariable Integer id
    ) throws NotFoundException {
        service.deleteById(id);
    }
}
