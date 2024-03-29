package org.adeda.samgtu_navigation.localization.service;

import jakarta.annotation.Nullable;
import org.adeda.samgtu_navigation.core.exception.AlreadyExistsException;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.localization.enums.SupportedLanguage;
import org.adeda.samgtu_navigation.localization.model.LocalizedString;
import org.adeda.samgtu_navigation.localization.repository.LocalizedStringRepository;
import org.adeda.samgtu_navigation.localization.schema.LocalizedStringSchema;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalizationServiceImpl implements LocalizationService {
    private final LocalizedStringRepository repository;

    public LocalizationServiceImpl(LocalizedStringRepository repository) {
        this.repository = repository;
    }

    @Override
    public LocalizedString create(LocalizedStringSchema schema) throws AlreadyExistsException {
        var result = repository.findByKey(schema.getKey(), schema.getLanguage()).orElse(null);
        if (result != null) {
            throw new AlreadyExistsException("LanguageString with given key and language already exists");
        }

        var str = new LocalizedString(
            schema.getLanguage(), schema.getLanguage().getConfigName(), schema.getKey(), schema.getText()
        );

        return repository.save(str);
    }

    @Override
    public List<LocalizedString> search(
        @Nullable String key,
        @Nullable SupportedLanguage language,
        Pageable pageable
    ) {
        return repository.search(key, language, pageable.getPageSize(), (int)pageable.getOffset());
    }

    @Override
    public Optional<String> getByKey(String key, SupportedLanguage language) {
        return repository.findByKey(key, language).map(LocalizedString::getText);
    }

    @Override
    public String getByKeySafe(String key, @Nullable SupportedLanguage language) {
        var fallback = String.format("[%s]", key);
        if (language == null) {
            return fallback;
        }
        return getByKey(key, language).orElse(fallback);
    }

    @Override
    public LocalizedString update(LocalizedStringSchema schema) throws NotFoundException {
        var str = repository.findByKey(schema.getKey(), schema.getLanguage()).orElse(null);
        if (str == null) {
            throw new NotFoundException("LocalizedString with given key and language was not found");
        }

        str.setText(schema.getText());

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
