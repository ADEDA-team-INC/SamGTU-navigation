package org.adeda.samgtu_navigation.map.schema;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.adeda.samgtu_navigation.map.model.BoundingBox;

@Getter
@Setter
public class BoundingBoxSchema {
    @NotNull
    private Double positionX;

    @NotNull
    private Double positionY;

    @NotNull
    private Double width;

    @NotNull
    private Double height;

    public static BoundingBoxSchema createFromModel(BoundingBox bbox) {
        var schema = new BoundingBoxSchema();

        schema.setPositionX(bbox.getPositionX());
        schema.setPositionY(bbox.getPositionY());
        schema.setWidth(bbox.getWidth());
        schema.setHeight(bbox.getHeight());

        return schema;
    }
}
