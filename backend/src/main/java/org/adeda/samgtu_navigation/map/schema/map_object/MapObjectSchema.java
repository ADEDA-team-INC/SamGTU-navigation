package org.adeda.samgtu_navigation.map.schema.map_object;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.adeda.samgtu_navigation.map.enums.MapObjectType;
import org.adeda.samgtu_navigation.map.schema.InfoSchema;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MapObjectSchema {
    @NotNull
    @Min(1)
    private Integer id;

    @NotNull
    private MapObjectType type;

    @NotNull
    private InfoSchema info;

    @NotNull
    @NotEmpty
    private List<BoundingBoxSchema> bboxes;
}
