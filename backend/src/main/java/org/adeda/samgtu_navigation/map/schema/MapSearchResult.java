package org.adeda.samgtu_navigation.map.schema;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.adeda.samgtu_navigation.map.schema.map_building.MapBuildingInfo;
import org.adeda.samgtu_navigation.map.schema.map_object.MapObjectInfo;
import org.adeda.samgtu_navigation.map.schema.outdoor_object.OutdoorObjectSchema;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MapSearchResult {
    @NotNull
    private List<MapBuildingInfo> mapBuildings;
    @NotNull
    private List<MapObjectInfo> mapObjects;
    @NotNull
    private List<OutdoorObjectSchema> outdoorObjects;
}
