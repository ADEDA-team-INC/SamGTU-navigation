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
    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinColumn(name = "map_object_id", nullable = false)
    @ToString.Exclude
    private MapObject mapObject;

    @NonNull
    @Embedded
    @Column(nullable = false)
    private Vector2d position;

    @NonNull
    @OneToMany(mappedBy = "nodeA", cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.EAGER)
    @ToString.Exclude
    private Set<NodesConnection> connections;
}
