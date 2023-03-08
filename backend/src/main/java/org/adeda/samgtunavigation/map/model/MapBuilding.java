package org.adeda.samgtunavigation.map.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class MapBuilding {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PRIVATE)
    private Integer id;

    @NonNull
    private Double latitude;

    @NonNull
    private Double longitude;

    private Integer number;

    private String displayName;

    private String displayDescription;

    @OneToMany(mappedBy = "building")
    private Set<Domain> domains;
}
