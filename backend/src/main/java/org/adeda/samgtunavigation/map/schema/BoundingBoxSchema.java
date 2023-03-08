package org.adeda.samgtunavigation.map.schema;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

@Data
public class BoundingBoxSchema {
    @NonNull
    @NotNull
    private Double positionX;

    @NonNull
    @NotNull
    private Double positionY;

    @NonNull
    @NotNull
    @Min(0)
    private Double width;

    @NonNull
    @NotNull
    @Min(0)
    private Double height;
}
