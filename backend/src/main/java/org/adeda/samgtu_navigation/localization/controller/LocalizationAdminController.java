package org.adeda.samgtu_navigation.localization.controller;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.adeda.samgtu_navigation.core.exception.AlreadyExistsException;
import org.adeda.samgtu_navigation.core.exception.InvalidFormatException;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.localization.enums.SupportedLanguage;
import org.adeda.samgtu_navigation.localization.model.LocalizedString;
import org.adeda.samgtu_navigation.localization.schema.LocalizedStringSchema;
import org.adeda.samgtu_navigation.localization.service.LocalizationService;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/localization")
@Validated
public class LocalizationAdminController {

    private final LocalizationService service;

    public LocalizationAdminController(LocalizationService service) {
        this.service = service;
    }

    @GetMapping("/strings")
    public List<LocalizedStringSchema> getLocalizedString(
        @RequestParam(defaultValue = "10") @NotNull @Min(1) Integer size,
        @RequestParam(defaultValue = "0") @NotNull @Min(0) Integer page,
        @RequestParam String key,
        @RequestParam String language
    ) throws InvalidFormatException {
        return service.search(key, SupportedLanguage.valueOf(language), PageRequest.of(page, size)).stream()
                .map(s -> new LocalizedStringSchema(s.getLanguage(), s.getKey(), s.getText())).toList();
    }

    @PostMapping("/string")
    public LocalizedStringSchema postLocalizedString(
        @RequestBody LocalizedStringSchema createSchema
    ) throws InvalidFormatException, AlreadyExistsException {
        LocalizedString localizedString = service.create(
                createSchema.getKey(),
                createSchema.getText(),
                createSchema.getLanguage());
        return new LocalizedStringSchema(localizedString.getLanguage(), localizedString.getKey(), localizedString.getText());
    }

    @PutMapping("/string")
    public LocalizedStringSchema putLocalizedString(
        @RequestBody LocalizedStringSchema createSchema
    ) throws NotFoundException,InvalidFormatException {
        LocalizedString localizedString = service.update(
                createSchema.getKey(),
                createSchema.getText(),
                createSchema.getLanguage());
        return new LocalizedStringSchema(localizedString.getLanguage(), localizedString.getKey(), localizedString.getText());
    }

    @DeleteMapping("/string")
    public void deleteLocalizedString(
        @RequestParam @NotBlank String key,
        @RequestParam @NotBlank String language
    ) throws NotFoundException {
        service.delete(key, SupportedLanguage.valueOf(language));
    }
}
