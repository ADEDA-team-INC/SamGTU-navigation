package org.adeda.samgtu_navigation.localization.enums;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.support.RequestContextUtils;

import java.util.Locale;

public enum SupportedLanguage {
    RUSSIAN, ENGLISH;

    public static SupportedLanguage byLocale(Locale locale) {
        return switch (locale.getLanguage()) {
            case "ru" -> RUSSIAN;
            case "en" -> ENGLISH;
            default -> throw new IllegalArgumentException();
        };
    }

    public static SupportedLanguage fromRequest(HttpServletRequest request) {
        return byLocale(RequestContextUtils.getLocale(request));
    }
}
