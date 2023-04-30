package org.adeda.samgtu_navigation.localization.config;

import org.adeda.samgtu_navigation.core.exception.AlreadyExistsException;
import org.adeda.samgtu_navigation.localization.enums.SupportedLanguage;
import org.adeda.samgtu_navigation.localization.schema.LocalizedStringSchema;
import org.adeda.samgtu_navigation.localization.service.LocalizationService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Component
public class InitialLocalesCreator implements ApplicationRunner {
    private final SupportedLanguage language = SupportedLanguage.RUSSIAN;
    private final Map<String, String> textsTable = Map.ofEntries(
        Map.entry("null",               ""),
        Map.entry("9th_building_name",  "9 корпус СамГТУ"),
        Map.entry("9th_building_descr", "Ново-Садовая ул., 10"),
        Map.entry("room_name",          "Кабинет"),
        Map.entry("room_descr",         "Описание кабинета"),
        Map.entry("restroom_name",      "Туалет"),
        Map.entry("restroom_descr",     "Описание"),
        Map.entry("magnit_shop_name",   "Магнит"),
        Map.entry("magnit_shop_descr",  "Первомайская ул., 25"),
        Map.entry("dodo_cafe_name",     "Додо Пицца"),
        Map.entry("dodo_cafe_descr",    "Ново-Садовая ул., 8А")
    );

    private final LocalizationService service;

    public InitialLocalesCreator(LocalizationService service) {
        this.service = service;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        for (var key : textsTable.keySet()) {
            var schema = new LocalizedStringSchema(language, key, textsTable.get(key));
            try {
                service.create(schema);
            } catch (AlreadyExistsException ignored) {
                service.update(schema);
            }
        }
    }
}
