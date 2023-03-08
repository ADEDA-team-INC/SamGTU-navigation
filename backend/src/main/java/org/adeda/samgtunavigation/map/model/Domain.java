package org.adeda.samgtunavigation.map.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PRIVATE)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "building_id", nullable = false)
    private MapBuilding building;

    @NonNull
    private Integer number;

    @Embedded
    private DomainImage image;

    @OneToMany(mappedBy = "domain")
    private Set<MapObject> mapObjects;
}
