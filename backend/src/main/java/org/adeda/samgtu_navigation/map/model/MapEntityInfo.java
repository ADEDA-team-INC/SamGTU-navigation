package org.adeda.samgtu_navigation.map.model;

import jakarta.persistence.*;
import lombok.*;

@Embeddable
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MapEntityInfo {
    // Множество URL адресов изображений,
    // разделенных символом перевода строки (\n)
    @NonNull
    @Column(nullable = false)
    private String imagesUrls;

    @NonNull
    @Column(nullable = false)
    private String nameKey;

    @NonNull
    @Column(nullable = false)
    private String descriptionKey;
}
