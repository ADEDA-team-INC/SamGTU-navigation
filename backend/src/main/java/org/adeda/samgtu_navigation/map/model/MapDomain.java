package org.adeda.samgtu_navigation.map.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
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

    @ManyToOne
    @JoinColumn(name = "building_id", nullable = false)
    private MapBuilding building;

    @Embedded
    private DomainImage image;

    @OneToMany(mappedBy = "domain")
    private Set<MapObject> mapObjects;
}
