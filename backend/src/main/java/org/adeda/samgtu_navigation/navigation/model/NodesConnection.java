package org.adeda.samgtu_navigation.navigation.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "nodes_connections", indexes = {
    @Index(columnList = "node_a_id, node_b_id", unique = true)
})
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class NodesConnection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PRIVATE)
    @EqualsAndHashCode.Include
    private Integer id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "node_a_id", nullable = false)
    private NavNode nodeA;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "node_b_id", nullable = false)
    private NavNode nodeB;
}
