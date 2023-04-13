package org.adeda.samgtu_navigation.map.schema;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InfoSchema {
    private List<String> images;

    private String displayName;

    private String displayDescription;
}
