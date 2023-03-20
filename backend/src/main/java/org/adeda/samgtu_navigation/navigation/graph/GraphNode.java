package org.adeda.samgtu_navigation.navigation.graph;

import lombok.*;
import org.adeda.samgtu_navigation.core.util.Vector2d;
import org.adeda.samgtu_navigation.navigation.model.NavNode;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
public class GraphNode {
    @NonNull
    @Setter(AccessLevel.PRIVATE)
    @EqualsAndHashCode.Include
    private NavNode navNode;

    @NonNull
    @Setter(AccessLevel.PRIVATE)
    private List<GraphNode> connections;

    public Vector2d getPosition() {
        return new Vector2d(navNode.getPositionX(), navNode.getPositionY());
    }
}
