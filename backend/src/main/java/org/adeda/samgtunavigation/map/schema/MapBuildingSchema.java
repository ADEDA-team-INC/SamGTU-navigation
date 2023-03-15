package org.adeda.samgtunavigation.map.schema;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.adeda.samgtunavigation.map.model.MapBuilding;
import org.adeda.samgtunavigation.map.model.MapDomain;

import java.util.List;

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

    @Min(0)
    private Integer number;

    @NotBlank
    private String displayName;

    @NotBlank
    private String displayDescription;

    @NotNull
    @NotEmpty
    private List<Integer> domainIds;

    public static MapBuildingSchema createFromModel(MapBuilding building) {
        var schema = new MapBuildingSchema();

        schema.setId(building.getId());
        schema.setLatitude(building.getLatitude());
        schema.setLongitude(building.getLongitude());
        schema.setNumber(building.getNumber());
        schema.setDisplayName(building.getDisplayName());
        schema.setDisplayDescription(building.getDisplayDescription());
        schema.setDomainIds(
            building.getDomains().stream().map(MapDomain::getId).toList()
        );

        return schema;
    }
}
