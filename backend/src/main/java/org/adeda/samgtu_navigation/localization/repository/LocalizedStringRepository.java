package org.adeda.samgtu_navigation.localization.repository;

import jakarta.annotation.Nullable;
import org.adeda.samgtu_navigation.localization.enums.SupportedLanguage;
import org.adeda.samgtu_navigation.localization.model.LocalizedString;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LocalizedStringRepository extends CrudRepository<LocalizedString, Integer> {
    @Query("SELECT str FROM LocalizedString str WHERE str.key = ?1 AND str.language = ?2")
    Optional<LocalizedString> findByKey(String key, SupportedLanguage language);

    @Query(value = """
        SELECT * FROM localized_strings WHERE
            (:key IS NULL OR key ILIKE CONCAT('%', :key, '%')) AND
            (:#{#lang == null} OR language = :#{#lang?.name()})
            LIMIT :limit OFFSET :offset
        """,
        nativeQuery = true
    )
    List<LocalizedString> search(
        @Nullable String key, @Nullable @Param("lang") SupportedLanguage language, int limit, int offset
    );
}
