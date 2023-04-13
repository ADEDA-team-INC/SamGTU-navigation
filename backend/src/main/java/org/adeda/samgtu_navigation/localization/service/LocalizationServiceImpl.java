package org.adeda.samgtu_navigation.localization.service;

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
    public Optional<String> getByKey(String key, SupportedLanguage language) {
        return repository.findByKey(key, language).map(LocalizedString::getText);
    }

    @Override
    public String getByKeySafe(String key, SupportedLanguage language) {
        return getByKey(key, language).orElse(String.format("[%s]", key));
    }
}
