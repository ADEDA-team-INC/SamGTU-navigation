package org.adeda.samgtu_navigation.map.schema.map_building;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.adeda.samgtu_navigation.map.schema.info.InfoCreateSchema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MapBuildingCreateSchema {
    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

    @NotNull
    private InfoCreateSchema info;
}
