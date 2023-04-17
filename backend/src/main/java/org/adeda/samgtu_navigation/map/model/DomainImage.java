package org.adeda.samgtu_navigation.map.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.*;
import org.adeda.samgtu_navigation.core.util.Vector2d;
import org.adeda.samgtu_navigation.map.schema.map_domain.DomainImageSchema;

@Embeddable
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class DomainImage {
    @NonNull
    @Column(nullable = false)
    private String url;

    @NonNull
    @Column(nullable = false)
    private Double width;

    @NonNull
    @Embedded
    private Vector2d offset;

    public DomainImage(DomainImageSchema schema) {
        this.url = schema.getUrl();
        this.width = schema.getWidth();
        this.offset = new Vector2d(schema.getOffsetX(), schema.getOffsetY());
    }
}
