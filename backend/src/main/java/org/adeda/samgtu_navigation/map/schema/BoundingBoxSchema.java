package org.adeda.samgtu_navigation.map.schema;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BoundingBoxSchema {
    @NotNull
    private Double positionX;

    @NotNull
    private Double positionY;

    @NotNull
    private Double width;

    @NotNull
    private Double height;
}
