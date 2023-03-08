package org.adeda.samgtunavigation.map.schema;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;
import org.adeda.samgtunavigation.map.enums.MapObjectType;

import java.util.List;

@Data
public class MapObjectSchema {
    @NonNull
    @NotNull
    @Min(1)
    private Integer id;

    @NonNull
    @NotNull
    private MapObjectType type;

    @Min(0)
    private Integer number;

    @NonNull
    @NotBlank
    private String displayName;

    @NonNull
    @NotBlank
    private String displayDescription;

    @NonNull
    @Size(min = 1)
    private List<BoundingBoxSchema> bboxes;
}
