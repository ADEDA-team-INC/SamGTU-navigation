package org.adeda.samgtu_navigation.map.schema.map_object;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.adeda.samgtu_navigation.map.enums.MapObjectType;
import org.adeda.samgtu_navigation.map.schema.info.InfoSchema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MapObjectInfo {
    @NotNull
    @Min(1)
    private Integer id;

    @NotNull
    private MapObjectType type;

    @NotNull
    private InfoSchema info;
}
