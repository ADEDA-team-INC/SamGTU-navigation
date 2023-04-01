package org.adeda.samgtu_navigation.map.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.*;
import org.adeda.samgtu_navigation.core.util.Vector2d;

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
}
