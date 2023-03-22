package org.adeda.samgtu_navigation.map.schema;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.adeda.samgtu_navigation.map.model.MapBuilding;
import org.adeda.samgtu_navigation.map.model.MapDomain;

import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
public class MapBuildingSchema {
    @NotNull
    @Min(1)
    private Integer id;

    @NotNull
    @Min(-90)
    @Max(90)
    private Double latitude;

    @NotNull
    @Min(-180)
    @Max(180)
    private Double longitude;

    @NotBlank
    private String displayName;

    @NotBlank
    private String displayDescription;

    @NotNull
    @NotEmpty
    private Map<Integer, Integer> domainIds;

    public static MapBuildingSchema createFromModel(MapBuilding building) {
        var schema = new MapBuildingSchema();

        schema.setId(building.getId());
        schema.setLatitude(building.getLatitude());
        schema.setLongitude(building.getLongitude());
        schema.setDisplayName(building.getDisplayName());
        schema.setDisplayDescription(building.getDisplayDescription());
        schema.setDomainIds(
            building.getDomains().stream().collect(
                Collectors.toMap(MapDomain::getOrdinalNumber, MapDomain::getId)
            )
        );

        return schema;
    }
}
