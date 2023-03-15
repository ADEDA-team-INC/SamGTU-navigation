package org.adeda.samgtunavigation.map.schema;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.adeda.samgtunavigation.map.enums.MapObjectType;
import org.adeda.samgtunavigation.map.model.MapObject;

import java.util.List;

@Getter
@Setter
public class MapObjectSchema {
    @NotNull
    @Min(1)
    private Integer id;

    @NotNull
    private MapObjectType type;

    private Integer number;

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
        schema.setNumber(mapObject.getNumber());
        schema.setDisplayName(mapObject.getDisplayName());
        schema.setDisplayDescription(mapObject.getDisplayDescription());
        schema.setBboxes(
            mapObject.getBoundingBoxes().stream().map(BoundingBoxSchema::createFromModel).toList()
        );

        return schema;
    }
}
