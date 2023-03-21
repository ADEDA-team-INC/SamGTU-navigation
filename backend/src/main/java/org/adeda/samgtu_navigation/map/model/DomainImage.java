package org.adeda.samgtu_navigation.map.model;

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
    private String url;

    @NonNull
    private Double width;

    @Embedded
    private Vector2d offset;
}
