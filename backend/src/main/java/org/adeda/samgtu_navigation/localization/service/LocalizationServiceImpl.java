package org.adeda.samgtu_navigation.localization.service;

import org.adeda.samgtu_navigation.localization.enums.SupportedLanguage;
import org.adeda.samgtu_navigation.localization.model.LocalizedString;
import org.adeda.samgtu_navigation.localization.repository.LocalizedStringRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LocalizationServiceImpl implements LocalizationService {
    private final LocalizedStringRepository repository;

    public LocalizationServiceImpl(LocalizedStringRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<String> getStringByKey(String key, SupportedLanguage language) {
        return repository.findByKey(key, language).map(LocalizedString::getText);
    }

    @Override
    public List<String> getStringsByKeys(List<String> keys, SupportedLanguage language) {
        var result = repository.findByKeys(keys, language).stream().collect(
            Collectors.toMap(
                tuple -> (String)tuple.get("key"),
                tuple -> (String)tuple.get("string")
            )
        );

        return keys.stream().map(result::get).toList();
    }
}
