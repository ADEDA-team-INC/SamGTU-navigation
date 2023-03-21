package org.adeda.samgtu_navigation.map.schema;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.adeda.samgtu_navigation.map.enums.MapObjectType;
import org.adeda.samgtu_navigation.map.model.MapObject;

import java.util.List;

@Getter
@Setter
public class MapObjectSchema {
    @NotNull
    @Min(1)
    private Integer id;

    @NotNull
    private MapObjectType type;

    @NotBlank
    private String displayName;

    @NotBlank
    private String displayDescription;

    @NotNull
    @NotEmpty
    private List<BoundingBoxSchema> bboxes;

    public static MapObjectSchema createFromModel(MapObject mapObject) {
        var schema = new MapObjectSchema();

        schema.setId(mapObject.getId());
        schema.setType(mapObject.getType());
        schema.setDisplayName(mapObject.getDisplayName());
        schema.setDisplayDescription(mapObject.getDisplayDescription());
        schema.setBboxes(
            mapObject.getBoundingBoxes().stream().map(
                bbox -> new BoundingBoxSchema(
                    bbox.getPosition().getX(), bbox.getPosition().getY(), bbox.getWidth(), bbox.getHeight()
                )
            ).toList()
        );

        return schema;
    }
}
