package org.adeda.samgtu_navigation.map.schema;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.adeda.samgtu_navigation.map.model.MapDomain;

import java.util.List;

@Getter
@Setter
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

    public static MapDomainSchema createFromModel(MapDomain domain) {
        var schema = new MapDomainSchema();

        schema.setId(domain.getId());
        schema.setMapBuildingId(domain.getBuilding().getId());
        schema.setImage(
            DomainImageSchema.createFromModel(domain.getImage())
        );
        schema.setMapObjects(
            domain.getMapObjects().stream().map(MapObjectSchema::createFromModel).toList()
        );

        return schema;
    }
}
