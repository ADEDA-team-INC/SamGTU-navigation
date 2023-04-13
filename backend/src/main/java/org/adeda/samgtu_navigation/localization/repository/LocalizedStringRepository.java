package org.adeda.samgtu_navigation.localization.repository;

import jakarta.persistence.Tuple;
import org.adeda.samgtu_navigation.localization.enums.SupportedLanguage;
import org.adeda.samgtu_navigation.localization.model.LocalizedString;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LocalizedStringRepository extends CrudRepository<LocalizedString, Integer> {
    @Query("SELECT str FROM LocalizedString str WHERE str.key = ?1 AND str.language = ?2")
    Optional<LocalizedString> findByKey(String key, SupportedLanguage language);

    @Query("""
        SELECT str.key AS key, str AS string
        FROM LocalizedString str WHERE
            str.language = ?2 AND str.key IN ?1
        """)
    List<Tuple> findByKeys(List<String> keys, SupportedLanguage language);
}
