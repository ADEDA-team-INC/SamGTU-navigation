package org.adeda.samgtu_navigation.navigation.schema;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.adeda.samgtu_navigation.core.validation.UniqueItems;
import org.adeda.samgtu_navigation.navigation.model.NavNode;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NavNodeSchema {
    @NotNull
    @Min(1)
    private Integer id;

    @Min(1)
    private Integer mapObjectId;

    @NotNull
    private Double positionX;

    @NotNull
    private Double positionY;

    @NotNull
    @UniqueItems
    private List<Integer> connectionsIds;

    public NavNodeSchema(NavNode node) {
        this.id = node.getId();
        this.mapObjectId = node.getMapObject().getId();
        this.positionX = node.getPosition().getX();
        this.positionY = node.getPosition().getY();
        this.connectionsIds = node.getConnections().stream().map(conn -> conn.getNodeB().getId()).toList();
    }
}
