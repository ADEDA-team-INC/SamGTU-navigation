package org.adeda.samgtu_navigation.navigation.schema;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NavigationRequest {
    @NotNull
    private NavPointSchema startPoint;

    @NotNull
    private NavPointSchema endPoint;
}
