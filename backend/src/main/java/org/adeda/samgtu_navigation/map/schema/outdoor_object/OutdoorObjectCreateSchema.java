package org.adeda.samgtu_navigation.map.schema.outdoor_object;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.adeda.samgtu_navigation.map.enums.OutdoorObjectType;
import org.adeda.samgtu_navigation.map.schema.info.InfoCreateSchema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OutdoorObjectCreateSchema {
    @NotNull
    private OutdoorObjectType type;

    @NotNull
    private Double latitude;

    @NonNull
    private Double longitude;

    @NotNull
    private InfoCreateSchema info;
}
