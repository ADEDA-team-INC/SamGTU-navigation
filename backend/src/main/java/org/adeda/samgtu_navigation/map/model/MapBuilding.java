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
    private Double latitude;

    @NonNull
    private Double longitude;

    @NonNull
    @ToString.Include
    private String displayName;

    @NonNull
    private String displayDescription;

    @OneToMany(mappedBy = "building")
    private Set<MapDomain> domains;
}
