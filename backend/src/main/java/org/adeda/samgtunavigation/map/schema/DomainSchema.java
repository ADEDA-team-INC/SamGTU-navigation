package org.adeda.samgtunavigation.map.schema;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class DomainSchema {
    @NonNull
    @NotNull
    @Min(1)
    private Integer id;

    @NotNull
    @NotNull
    @Min(1)
    private Integer mapBuildingId;

    @Min(1)
    private Integer number;

    @NonNull
    @NotNull
    private DomainImageSchema image;

    @NonNull
    @NotNull
    @Size(min = 1)
    private List<MapObjectSchema> mapObjects;
}
