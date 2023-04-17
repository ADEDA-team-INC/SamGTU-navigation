package org.adeda.samgtu_navigation.map.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.adeda.samgtu_navigation.localization.enums.SupportedLanguage;
import org.adeda.samgtu_navigation.map.schema.MapSearchResult;
import org.adeda.samgtu_navigation.map.service.MapService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/map")
@Validated
public class MapController {
    private final MapService service;

    public MapController(MapService service) {
        this.service = service;
    }

    @GetMapping("/search")
    public MapSearchResult searchMapEntities(
        @RequestParam @NotBlank String query,
        @RequestParam(defaultValue = "10") @NotNull Integer size,
        HttpServletRequest request
    ) {
        return service.search(query, SupportedLanguage.fromRequest(request), size);
    }
}
