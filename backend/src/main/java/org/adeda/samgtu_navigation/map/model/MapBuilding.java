package org.adeda.samgtu_navigation.map.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "map_buildings", indexes = {
    @Index(columnList = "nameKey"),
    @Index(columnList = "descriptionKey")
})
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class MapBuilding {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PRIVATE)
    @EqualsAndHashCode.Include
    @ToString.Include
    private Integer id;

    @NonNull
    @Column(nullable = false)
    private Double latitude;

    @NonNull
    @Column(nullable = false)
    private Double longitude;

    @NonNull
    @Embedded
    @Column(nullable = false)
    private MapEntityInfo info;

    @NonNull
    @OneToMany(mappedBy = "building", cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    private Set<MapDomain> domains;
}
