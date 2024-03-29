package org.adeda.samgtu_navigation.map.schema.map_object;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.adeda.samgtu_navigation.core.util.Rect;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoundingBoxSchema {
    @NotNull
    private Double positionX;

    @NotNull
    private Double positionY;

    @NotNull
    private Double width;

    @NotNull
    private Double height;

    public BoundingBoxSchema(Rect rect) {
        this.positionX = rect.getPosition().getX();
        this.positionY = rect.getPosition().getY();
        this.width = rect.getWidth();
        this.height = rect.getHeight();
    }

    public Rect asRect() {
        return new Rect(getPositionX(), getPositionY(), getWidth(), getHeight());
    }
}
