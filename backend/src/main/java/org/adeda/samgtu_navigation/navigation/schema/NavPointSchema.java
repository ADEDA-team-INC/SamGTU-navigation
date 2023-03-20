package org.adeda.samgtu_navigation.navigation.schema;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.adeda.samgtu_navigation.core.util.Vector2d;

@Getter
@Setter
public class NavPointSchema {
    @NotNull
    private Double positionX;

    @NotNull
    private Double positionY;

    @NotNull
    @Min(1)
    private Integer domainId;

    public NavPointSchema(Vector2d position, Integer domainId) {
        this.positionX = position.getX();
        this.positionY = position.getY();
        this.domainId = domainId;
    }
}
