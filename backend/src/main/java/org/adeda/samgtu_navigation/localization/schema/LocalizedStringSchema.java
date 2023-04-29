package org.adeda.samgtu_navigation.localization.schema;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.adeda.samgtu_navigation.localization.enums.SupportedLanguage;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocalizedStringSchema {

    @NotNull
    private SupportedLanguage language;

    @NotNull
    @NotBlank
    private String key;

    @NotNull
    @NotBlank
    private String text;
}
