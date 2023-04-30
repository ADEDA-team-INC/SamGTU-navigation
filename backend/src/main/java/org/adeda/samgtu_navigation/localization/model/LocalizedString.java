package org.adeda.samgtu_navigation.localization.model;

import jakarta.persistence.*;
import lombok.*;
import org.adeda.samgtu_navigation.localization.enums.SupportedLanguage;

@Entity
@Table(name = "localized_strings", indexes = {
    @Index(columnList = "key, language", unique = true)
})
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class LocalizedString {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PRIVATE)
    @EqualsAndHashCode.Include
    private Integer id;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SupportedLanguage language;

    @NonNull
    @Column(nullable = false)
    private String configName;

    @NonNull
    @Column(nullable = false)
    private String key;

    @NonNull
    @Column(columnDefinition = "text", nullable = false)
    private String text;
}
