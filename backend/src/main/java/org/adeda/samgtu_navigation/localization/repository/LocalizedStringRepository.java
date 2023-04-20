package org.adeda.samgtu_navigation.localization.repository;

import jakarta.annotation.Nullable;
import org.adeda.samgtu_navigation.localization.enums.SupportedLanguage;
import org.adeda.samgtu_navigation.localization.model.LocalizedString;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LocalizedStringRepository extends CrudRepository<LocalizedString, Integer> {
    @Query("SELECT str FROM LocalizedString str WHERE str.key = ?1 AND str.language = ?2")
    Optional<LocalizedString> findByKey(String key, SupportedLanguage language);

    @Query(value = """
        SELECT * FROM localized_strings WHERE
            (?1 IS NULL OR text ILIKE CONCAT('%', ?1, '%')) AND
            (?2 IS NULL OR language = ?2)
            LIMIT ?3 OFFSET ?4
        """,
        nativeQuery = true
    )
    List<LocalizedString> search(@Nullable String key, @Nullable SupportedLanguage language, int limit, int offset);
}
