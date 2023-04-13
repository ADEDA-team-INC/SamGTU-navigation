package org.adeda.samgtu_navigation.map.model;

import jakarta.persistence.*;
import lombok.*;
import org.adeda.samgtu_navigation.core.util.Rect;
import org.adeda.samgtu_navigation.core.util.Vector2d;
import org.adeda.samgtu_navigation.map.enums.MapObjectType;
import org.adeda.samgtu_navigation.navigation.model.NavNode;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "map_objects", indexes = {
    @Index(columnList = "type")
})
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

    @NonNull
    @ManyToOne
    @JoinColumn(name = "domain_id", nullable = false)
    private MapDomain domain;

    @NonNull
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private MapObjectType type;

    @NonNull
    @Embedded
    @Column(nullable = false)
    private MapEntityInfo info;

    @NonNull
    @ElementCollection
    @Column(nullable = false)
    private List<Rect> boundingBoxes;

    @OneToMany(mappedBy = "mapObject")
    private Set<NavNode> nodes;

    public boolean containsPoint(Vector2d point) {
        return boundingBoxes.stream().allMatch(rect -> rect.containsPoint(point));
    }
}
