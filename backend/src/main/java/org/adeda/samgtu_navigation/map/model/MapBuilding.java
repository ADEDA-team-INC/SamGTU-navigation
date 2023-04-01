package org.adeda.samgtu_navigation.map.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "map_buildings")
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
    @Column(nullable = false)
    @ToString.Include
    private String displayName;

    @NonNull
    @Column(nullable = false)
    private String displayDescription;

    @OneToMany(mappedBy = "building")
    private Set<MapDomain> domains;
}
