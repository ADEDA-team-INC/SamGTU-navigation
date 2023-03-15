package org.adeda.samgtunavigation.map.model;

import jakarta.persistence.*;
import lombok.*;
import org.adeda.samgtunavigation.map.enums.MapObjectType;
import org.adeda.samgtunavigation.navigation.model.NavNode;

import java.util.Set;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class MapObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PRIVATE)
    @EqualsAndHashCode.Include
    @ToString.Include
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "domain_id", nullable = false)
    private MapDomain domain;

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

    @OneToMany(mappedBy = "mapObject")
    private Set<NavNode> nodes;
}
