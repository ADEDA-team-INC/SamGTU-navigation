package org.adeda.samgtunavigation.map.model;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class DomainImage {
    @NonNull
    private String url;

    @NonNull
    private Double realWidth;

    @NonNull
    private Double realOffsetX;

    @NonNull
    private Double realOffsetY;
}
