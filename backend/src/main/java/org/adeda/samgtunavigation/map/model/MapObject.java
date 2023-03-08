package org.adeda.samgtunavigation.map.model;

import jakarta.persistence.*;
import lombok.*;
import org.adeda.samgtunavigation.map.enums.MapObjectType;

import java.util.Set;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class MapObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PRIVATE)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "domain_id", nullable = false)
    private Domain domain;

    @NonNull
    @Enumerated(EnumType.ORDINAL)
    private MapObjectType type;

    private Integer number;

    @NonNull
    private String displayName;

    @NonNull
    private String displayDescription;

    @OneToMany(mappedBy = "mapObject")
    private Set<BoundingBox> boundingBoxes;
}
