package org.adeda.samgtu_navigation.map.schema.map_object;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.adeda.samgtu_navigation.map.enums.MapObjectType;
import org.adeda.samgtu_navigation.map.schema.info.InfoCreateSchema;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MapObjectCreateSchema {
    @NotNull
    private MapObjectType type;

    @NotNull
    private InfoCreateSchema info;

    @NotNull
    @NotEmpty
    private List<BoundingBoxSchema> bboxes;
}
