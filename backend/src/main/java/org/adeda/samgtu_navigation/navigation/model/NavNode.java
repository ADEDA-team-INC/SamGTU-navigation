package org.adeda.samgtu_navigation.navigation.model;

import jakarta.persistence.*;
import lombok.*;
import org.adeda.samgtu_navigation.core.util.Vector2d;
import org.adeda.samgtu_navigation.map.model.MapObject;

import java.util.Set;

@Entity
@Table(name = "nodes")
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

    @Embedded
    @NonNull
    private Vector2d position;

    @OneToMany(mappedBy = "nodeA", fetch = FetchType.EAGER)
    @ToString.Exclude
    private Set<NodesConnection> connections;
}
