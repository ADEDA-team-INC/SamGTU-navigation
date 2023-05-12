package org.adeda.samgtu_navigation.localization.service;

import jakarta.annotation.Nullable;
import org.adeda.samgtu_navigation.core.exception.AlreadyExistsException;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.localization.enums.SupportedLanguage;
import org.adeda.samgtu_navigation.localization.model.LocalizedString;
import org.adeda.samgtu_navigation.localization.schema.LocalizedStringSchema;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface LocalizationService {
    /**
     * Метод создания новой локализованной строки
     * @param schema Объект строки
     * @return Ссылка на строку, хранящуюся в базе данных
     * @throws AlreadyExistsException Если строка с данным ключом и языком уже существует
     */
    LocalizedString create(LocalizedStringSchema schema) throws AlreadyExistsException;

    /**
     * Метод поиска локализованных строк
     * @param key Подстрока, по которой нужно искать строки. Если равен `null`, то не учитывается в поиске.
     * @param language Язык строк, по которому нужно их искать. Если равен `null`, то не учитывается в поискею
     * @param pageable Объект страницы
     * @return Список локализованных строк, подходящих по критериям и отсортированных по id.
     */
    List<LocalizedString> search(
        @Nullable String key,
        @Nullable SupportedLanguage language,
        Pageable pageable
    );

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
    String getByKeySafe(String key, @Nullable SupportedLanguage language);

    /**
     * Метод обновления текста существующей строки
     * @param schema Объект строки
     * @return Объект обновленной строки
     * @throws NotFoundException Если строка с данным ключом и языком не существует
     */
    LocalizedString update(LocalizedStringSchema schema) throws NotFoundException;

    /**
     * Метод удаления локализованной строки
     * @param key ключ строки
     * @param language язык строки
     * @throws NotFoundException Данная строка не была найдена.
     */
    void delete(String key, SupportedLanguage language) throws NotFoundException;
}
