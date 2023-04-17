package org.adeda.samgtu_navigation.localization.service;

import org.adeda.samgtu_navigation.core.exception.AlreadyExistsException;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.localization.enums.SupportedLanguage;
import org.adeda.samgtu_navigation.localization.model.LocalizedString;
import org.adeda.samgtu_navigation.localization.repository.LocalizedStringRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocalizationServiceImpl implements LocalizationService {
    private final LocalizedStringRepository repository;

    public LocalizationServiceImpl(LocalizedStringRepository repository) {
        this.repository = repository;
    }

    @Override
    public LocalizedString create(String key, String text, SupportedLanguage language) throws AlreadyExistsException {
        var result = repository.findByKey(key, language).orElse(null);
        if (result != null) {
            throw new AlreadyExistsException("LanguageString with given key and language already exists");
        }

        var str = new LocalizedString(
            language, language.getDbConfigName(), key, text
        );

        return repository.save(str);
    }

    @Override
    public Optional<String> getByKey(String key, SupportedLanguage language) {
        return repository.findByKey(key, language).map(LocalizedString::getText);
    }

    @Override
    public String getByKeySafe(String key, SupportedLanguage language) {
        return getByKey(key, language).orElse(String.format("[%s]", key));
    }

    @Override
    public LocalizedString update(String key, String text, SupportedLanguage language) throws NotFoundException {
        var str = repository.findByKey(key, language).orElse(null);
        if (str == null) {
            throw new NotFoundException("LocalizedString with given key and language was not found");
        }

        str.setText(text);

        return repository.save(str);
    }

    @Override
    public void delete(String key, SupportedLanguage language) throws NotFoundException {
        var str = repository.findByKey(key, language).orElse(null);
        if (str == null) {
            throw new NotFoundException("LocalizedString with given key and language was not found");
        }

        repository.delete(str);
    }
}
