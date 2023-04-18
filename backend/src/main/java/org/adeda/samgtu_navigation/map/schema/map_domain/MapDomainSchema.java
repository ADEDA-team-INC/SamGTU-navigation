package org.adeda.samgtu_navigation.map.schema.map_domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.adeda.samgtu_navigation.map.schema.map_object.MapObjectSchema;

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
    private DomainImageSchema image;

    @NotNull
    @NotEmpty
    private List<MapObjectSchema> mapObjects;
}
