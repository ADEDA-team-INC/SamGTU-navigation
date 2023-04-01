package org.adeda.samgtu_navigation.map.schema;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.adeda.samgtu_navigation.map.model.MapBuilding;
import org.adeda.samgtu_navigation.map.model.MapDomain;

import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class MapBuildingSchema {
    @NotNull
    @Min(1)
    private Integer id;

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

    @NotBlank
    private String displayName;

    @NotBlank
    private String displayDescription;

    @NotNull
    @NotEmpty
    private Map<Integer, Integer> domainIds;

    public MapBuildingSchema(MapBuilding building) {
        this.id = building.getId();
        this.latitude = building.getLatitude();
        this.longitude = building.getLongitude();
        this.displayName = building.getDisplayName();
        this.displayDescription = building.getDisplayDescription();
        this.domainIds = building
            .getDomains()
            .stream()
            .collect(
                Collectors.toMap(MapDomain::getOrdinalNumber, MapDomain::getId)
            );
    }
}
