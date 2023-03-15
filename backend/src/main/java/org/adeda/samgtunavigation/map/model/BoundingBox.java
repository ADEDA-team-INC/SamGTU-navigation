package org.adeda.samgtunavigation.map.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class BoundingBox {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PRIVATE)
    @EqualsAndHashCode.Include
    @ToString.Exclude
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "map_object_id", nullable = false)
    @ToString.Exclude
    private MapObject mapObject;

    @NonNull
    private Double positionX;

    @NonNull
    private Double positionY;

    @NonNull
    private Double width;

    @NonNull
    private Double height;
}
