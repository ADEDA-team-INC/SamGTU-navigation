package org.adeda.samgtu_navigation.navigation.controller;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.adeda.samgtu_navigation.core.exception.InvalidFormatException;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.navigation.schema.NavPointSchema;
import org.adeda.samgtu_navigation.navigation.service.NavigationService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
public class NavigationControllerImpl {
    private final NavigationService service;

    public NavigationControllerImpl(NavigationService service) {
        this.service = service;
    }

    @PostMapping("/navigation")
    public List<NavPointSchema> findPath(
        @RequestBody @NotNull @Size(min = 2) List<NavPointSchema> points
    ) throws NotFoundException, InvalidFormatException {
        return service.findPath(points);
    }
}
