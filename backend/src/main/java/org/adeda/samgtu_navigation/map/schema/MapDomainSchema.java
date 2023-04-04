package org.adeda.samgtu_navigation.map.schema;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.adeda.samgtu_navigation.map.model.MapDomain;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MapDomainSchema {
    @NotNull
    @Min(1)
    private Integer id;

    @NotNull
    private Integer mapBuildingId;

    @NotNull
    private DomainImageSchema image;

    @NotNull
    @NotEmpty
    private List<MapObjectSchema> mapObjects;

    public MapDomainSchema(MapDomain domain) {
        this.id = domain.getId();
        this.mapBuildingId = domain.getBuilding().getId();
        this.image = new DomainImageSchema(domain.getImage());
        this.mapObjects = domain.getMapObjects().stream().map(MapObjectSchema::new).toList();
    }
}
