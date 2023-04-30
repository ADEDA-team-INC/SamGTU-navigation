package org.adeda.samgtu_navigation.navigation.schema;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.adeda.samgtu_navigation.core.util.Vector2d;
import org.adeda.samgtu_navigation.navigation.model.NavNode;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @JsonIgnore
    public Vector2d getPosition() {
        return new Vector2d(positionX, positionY);
    }
}
