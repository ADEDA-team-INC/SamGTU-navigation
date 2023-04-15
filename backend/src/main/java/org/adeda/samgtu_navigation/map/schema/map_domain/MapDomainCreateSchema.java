package org.adeda.samgtu_navigation.map.schema.map_domain;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MapDomainCreateSchema {
    @NotNull
    private Integer ordinalNumber;

    @NotNull
    private DomainImageSchema image;
}
