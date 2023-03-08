package org.adeda.samgtunavigation.map.schema;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.URL;

@Data
public class DomainImageSchema {
    @NonNull
    @NotNull
    @URL
    private String url;

    @NonNull
    @NotNull
    @Min(0)
    private Double realWidth;

    @NonNull
    @NotNull
    private Double realOffsetX;

    @NonNull
    @NotNull
    private Double realOffsetY;
}
