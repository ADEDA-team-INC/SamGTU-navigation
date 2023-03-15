package org.adeda.samgtunavigation.navigation.model;

import jakarta.persistence.*;
import lombok.*;
import org.adeda.samgtunavigation.map.model.MapObject;

import java.util.Set;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class NavNode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PRIVATE)
    @EqualsAndHashCode.Include
    private Integer id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "map_object_id", nullable = false)
    @ToString.Exclude
    private MapObject mapObject;

    @NonNull
    private Double positionX;

    @NonNull
    private Double positionY;

    @OneToMany(mappedBy = "nodeA")
    @ToString.Exclude
    private Set<NodesConnection> connections;
}
