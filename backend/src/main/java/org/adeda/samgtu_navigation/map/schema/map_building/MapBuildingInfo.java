package org.adeda.samgtu_navigation.map.schema.map_building;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.adeda.samgtu_navigation.map.schema.common.InfoSchema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MapBuildingInfo {
    @NotNull
    @Min(1)
    private Integer id;

    @NotNull
    private InfoSchema info;
}
