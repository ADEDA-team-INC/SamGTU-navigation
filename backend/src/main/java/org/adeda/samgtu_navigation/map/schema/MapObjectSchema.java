package org.adeda.samgtu_navigation.map.schema;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.adeda.samgtu_navigation.map.enums.MapObjectType;
import org.adeda.samgtu_navigation.map.model.MapObject;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
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

    public MapObjectSchema(MapObject mapObject) {
        this.id = mapObject.getId();
        this.type = mapObject.getType();
        this.displayName = mapObject.getDisplayName();
        this.displayDescription = mapObject.getDisplayDescription();
        this.bboxes = mapObject.getBoundingBoxes().stream().map(BoundingBoxSchema::new).toList();
    }
}
