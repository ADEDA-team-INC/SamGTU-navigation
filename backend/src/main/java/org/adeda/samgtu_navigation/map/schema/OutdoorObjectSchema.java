package org.adeda.samgtu_navigation.map.schema;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.adeda.samgtu_navigation.map.enums.OutdoorObjectType;
import org.adeda.samgtu_navigation.map.model.OutdoorObject;

@Getter
@Setter
@AllArgsConstructor
public class OutdoorObjectSchema {
    @NotNull
    @Min(1)
    private Integer id;

    @NotNull
    private OutdoorObjectType type;

    @NotBlank
    private String displayName;

    @NotBlank
    private String displayDescription;

    public OutdoorObjectSchema(OutdoorObject outdoorObject) {
        this.id = outdoorObject.getId();
        this.type = outdoorObject.getType();
        this.displayName = outdoorObject.getDisplayName();
        this.displayDescription = outdoorObject.getDisplayDescription();
    }
}
