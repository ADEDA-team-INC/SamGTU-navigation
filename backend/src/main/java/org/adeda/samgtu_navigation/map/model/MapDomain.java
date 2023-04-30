package org.adeda.samgtu_navigation.map.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "map_domains")
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class MapDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PRIVATE)
    @EqualsAndHashCode.Include
    @ToString.Include
    private Integer id;

    @NonNull
    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinColumn(name = "building_id", nullable = false)
    private MapBuilding building;

    @NonNull
    @Embedded
    @Column(nullable = false)
    private DomainImage image;

    @NonNull
    @Column(nullable = false)
    private Integer ordinalNumber;

    @NonNull
    @OneToMany(mappedBy = "domain", cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    private Set<MapObject> mapObjects;
}
