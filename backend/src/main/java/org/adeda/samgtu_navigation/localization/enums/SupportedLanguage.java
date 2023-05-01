package org.adeda.samgtu_navigation.localization.enums;

import jakarta.annotation.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import org.adeda.samgtu_navigation.core.exception.InvalidFormatException;
import org.springframework.web.servlet.support.RequestContextUtils;

import java.util.Locale;

public enum SupportedLanguage {
    RUSSIAN("russian"),
    ENGLISH("english");

    @Getter
    private final String configName;

    SupportedLanguage(String dbLanguage) {
        this.configName = dbLanguage;
    }

    public static @Nullable SupportedLanguage byLocale(Locale locale) {
        return switch (locale.getLanguage()) {
            case "ru" -> RUSSIAN;
            case "en" -> ENGLISH;
            default -> null;
        };
    }

    public static @Nullable SupportedLanguage fromRequest(HttpServletRequest request) {
        return byLocale(RequestContextUtils.getLocale(request));
    }
}
