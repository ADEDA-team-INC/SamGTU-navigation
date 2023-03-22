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
    @ManyToOne
    @JoinColumn(name = "building_id", nullable = false)
    private MapBuilding building;

    @NonNull
    @Embedded
    private DomainImage image;

    @NonNull
    private Integer ordinalNumber;

    @OneToMany(mappedBy = "domain")
    private Set<MapObject> mapObjects;
}
