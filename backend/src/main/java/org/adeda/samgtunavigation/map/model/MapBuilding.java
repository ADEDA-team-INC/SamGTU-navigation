package org.adeda.samgtunavigation.map.model;

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

    private Integer number;

    @ToString.Include
    private String displayName;

    private String displayDescription;

    @OneToMany(mappedBy = "building")
    private Set<MapDomain> domains;
}
