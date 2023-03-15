package org.adeda.samgtunavigation.navigation.schema;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.adeda.samgtunavigation.core.util.Vector2;

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

    public NavPointSchema(Vector2 position, Integer domainId) {
        this.positionX = position.getX();
        this.positionY = position.getY();
        this.domainId = domainId;
    }
}
