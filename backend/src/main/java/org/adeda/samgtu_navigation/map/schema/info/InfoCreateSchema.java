package org.adeda.samgtu_navigation.map.schema.info;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InfoCreateSchema {
    @NotNull
    private List<String> images;

    @NotBlank
    private String nameKey;

    @NotBlank
    private String descriptionKey;
}
