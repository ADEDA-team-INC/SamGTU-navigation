package org.adeda.samgtu_navigation.map.model;

import jakarta.persistence.*;
import lombok.*;
import org.adeda.samgtu_navigation.core.util.Rect;
import org.adeda.samgtu_navigation.map.enums.MapObjectType;
import org.adeda.samgtu_navigation.navigation.model.NavNode;

import java.util.List;
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

    @NonNull
    private String displayName;

    @NonNull
    private String displayDescription;

    @ElementCollection
    private List<Rect> boundingBoxes;

    @OneToMany(mappedBy = "mapObject")
    private Set<NavNode> nodes;
}
