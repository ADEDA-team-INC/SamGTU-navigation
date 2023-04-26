package org.adeda.samgtu_navigation.navigation.schema;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.adeda.samgtu_navigation.core.validation.UniqueItems;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NavNodeCreateSchema {
    @Min(1)
    private Integer mapObjectId;

    @NotNull
    private Double positionX;

    @NotNull
    private Double positionY;

    @NotNull
    @UniqueItems
    private List<Integer> connectionsIds;
}
