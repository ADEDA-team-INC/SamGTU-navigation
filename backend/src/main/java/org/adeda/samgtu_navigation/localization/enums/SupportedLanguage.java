package org.adeda.samgtu_navigation.localization.enums;

import lombok.Getter;

import java.util.Locale;

public enum SupportedLanguage {
    RUSSIAN("russian"),
    ENGLISH("english");

    @Getter
    private final String dbConfigName;

    SupportedLanguage(String dbLanguage) {
        this.dbConfigName = dbLanguage;
    }

    public static SupportedLanguage byLocale(Locale locale) {
        return switch (locale.getLanguage()) {
            case "ru" -> RUSSIAN;
            case "en" -> ENGLISH;
        };
    }
}
