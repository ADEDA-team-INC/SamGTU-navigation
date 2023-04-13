package org.adeda.samgtu_navigation.localization.service;

import org.adeda.samgtu_navigation.localization.enums.SupportedLanguage;

import java.util.List;
import java.util.Optional;

public interface LocalizationService {
    /**
     * Метод получения локализованной(переведенной) строки.
     * @param key ключ, по которому искать значение строчки
     * @param language поддерживаемый язык, для которого нужно получить перевод
     * @return Переведенная строка, либо `Optional.empty()`, если перевода на данный язык не существует,
     * либо данного ключа нет в таблице.
     */
    Optional<String> getStringByKey(String key, SupportedLanguage language);

    /**
     * Метод получения множества локализованных(переведенных) строк.
     * @param keys Список ключей, по которым нужно получить значения строки.
     * @param language поддерживаемый язык, для которого нужно получить перевод
     * @return Список переведенных строк в том же порядке, что и ключи. Если перевод для ключа не доступен,
     * то значение строчки будет равно `null`.
     */
    List<String> getStringsByKeys(List<String> keys, SupportedLanguage language);
}
