package org.adeda.samgtu_navigation.localization.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.adeda.samgtu_navigation.core.exception.AlreadyExistsException;
import org.adeda.samgtu_navigation.core.exception.InvalidFormatException;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.localization.enums.SupportedLanguage;
import org.adeda.samgtu_navigation.localization.schema.LocalizedStringSchema;
import org.adeda.samgtu_navigation.localization.service.LocalizationService;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/admin/localization")
@Validated
public class LocalizationAdminController {
    private final LocalizationService service;

    public LocalizationAdminController(LocalizationService service) {
        this.service = service;
    }

    @GetMapping("/strings")
    public List<LocalizedStringSchema> getLocalizedStrings(
        @RequestParam(defaultValue = "10") @NotNull @Min(1) Integer size,
        @RequestParam(defaultValue = "0") @NotNull @Min(0) Integer page,
        @RequestParam(required = false) String key,
        @RequestParam(required = false) SupportedLanguage language
    ) throws InvalidFormatException {
        return service.search(
            key, language, PageRequest.of(page, size)
        ).stream().map(LocalizedStringSchema::new).toList();
    }

    @PostMapping("/string")
    public LocalizedStringSchema createLocalizedString(
        @RequestBody @Valid LocalizedStringSchema schema
    ) throws InvalidFormatException, AlreadyExistsException {
        return new LocalizedStringSchema(service.create(schema));
    }

    @PutMapping("/string")
    public LocalizedStringSchema updateLocalizedString(
        @RequestBody @Valid LocalizedStringSchema schema
    ) throws NotFoundException,InvalidFormatException {
        return new LocalizedStringSchema(service.update(schema));
    }

    @DeleteMapping("/string")
    public void deleteLocalizedString(
        @RequestParam @NotBlank String key,
        @RequestParam @NotNull SupportedLanguage language
    ) throws NotFoundException {
        service.delete(key, language);
    }
}
