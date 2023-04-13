package org.adeda.samgtu_navigation.map.schema.map_building;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.adeda.samgtu_navigation.map.schema.common.InfoSchema;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MapBuildingSchema {
    @NotNull
    @Min(1)
    private Integer id;

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

    @NotNull
    private InfoSchema info;

    @NotNull
    @NotEmpty
    private Map<Integer, Integer> domainIds;
}
