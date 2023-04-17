package org.adeda.samgtu_navigation.map.model;

import jakarta.persistence.*;
import lombok.*;
import org.adeda.samgtu_navigation.map.schema.info.InfoCreateSchema;

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
    @Column(columnDefinition = "text", nullable = false)
    private String imagesUrls;

    @NonNull
    @Column(nullable = false)
    private String nameKey;

    @NonNull
    @Column(nullable = false)
    private String descriptionKey;

    public MapEntityInfo(InfoCreateSchema schema) {
        this.imagesUrls = String.join("\n", schema.getImages());
        this.nameKey = schema.getNameKey();
        this.descriptionKey = schema.getDescriptionKey();
    }
}
