package org.adeda.samgtu_navigation.navigation.schema;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.adeda.samgtu_navigation.core.util.Vector2d;
import org.adeda.samgtu_navigation.navigation.model.NavNode;

@Getter
@Setter
@AllArgsConstructor
public class NavPointSchema {
    @NotNull
    private Double positionX;

    @NotNull
    private Double positionY;

    @NotNull
    @Min(1)
    private Integer mapObjectId;

    public NavPointSchema(NavNode node) {
        this.positionX = node.getPosition().getX();
        this.positionY = node.getPosition().getY();
        this.mapObjectId = node.getMapObject().getId();
    }

    public Vector2d getPosition() {
        return new Vector2d(positionX, positionY);
    }
}
