package org.adeda.samgtu_navigation.localization.service;

import org.adeda.samgtu_navigation.localization.enums.SupportedLanguage;

import java.util.Optional;

public interface LocalizationService {
    /**
     * Метод получения локализованной(переведенной) строки.
     * @param key ключ, по которому искать значение строчки
     * @param language поддерживаемый язык, для которого нужно получить перевод
     * @return Переведенная строка, либо `Optional.empty()`, если перевода на данный язык не существует,
     * либо данного ключа нет в таблице.
     */
    Optional<String> getByKey(String key, SupportedLanguage language);

    /**
     * Метод "безопасного" получения строки.
     * @param key ключ, по которому искать значение строчки
     * @param language поддерживаемый язык, для которого нужно получить перевод
     * @return Переведенная строка, либо значение самого ключа, если перевод не найден.
     */
    String getByKeySafe(String key, SupportedLanguage language);
}
