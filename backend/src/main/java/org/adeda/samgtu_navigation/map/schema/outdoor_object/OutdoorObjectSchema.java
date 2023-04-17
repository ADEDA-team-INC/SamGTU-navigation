package org.adeda.samgtu_navigation.map.schema.outdoor_object;

import jakarta.validation.constraints.*;
import lombok.*;
import org.adeda.samgtu_navigation.map.enums.OutdoorObjectType;
import org.adeda.samgtu_navigation.map.schema.info.InfoSchema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OutdoorObjectSchema {
    @NotNull
    @Min(1)
    private Integer id;

    @NotNull
    private OutdoorObjectType type;

    @NotNull
    private Double latitude;

    @NonNull
    private Double longitude;

    @NotNull
    private InfoSchema info;
}
