package org.adeda.samgtunavigation.map.schema;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class MapBuildingSchema {
    @NonNull
    @NotNull
    @Min(1)
    private Integer id;

    @NonNull
    @NotNull
    @Min(-90)
    @Max(90)
    private Double latitude;

    @NonNull
    @NotNull
    @Min(-180)
    @Max(180)
    private Double longitude;

    @Min(0)
    private Integer number;

    @NonNull
    @NotBlank
    private String displayName;

    @NonNull
    @NotBlank
    private String displayDescription;

    @NonNull
    @NotNull
    @Size(min = 1)
    private List<Integer> domainIds;
}
