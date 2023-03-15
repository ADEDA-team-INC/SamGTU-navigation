package org.adeda.samgtu_navigation.map.schema;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.adeda.samgtu_navigation.map.model.DomainImage;
import org.hibernate.validator.constraints.URL;

@Getter
@Setter
public class DomainImageSchema {
    @NotNull
    @URL
    private String url;

    @NotNull
    private Double realWidth;

    @NotNull
    private Double realOffsetX;

    @NotNull
    private Double realOffsetY;

    public static DomainImageSchema createFromModel(DomainImage domainImage) {
        var schema = new DomainImageSchema();

        schema.setUrl(domainImage.getUrl());
        schema.setRealWidth(domainImage.getRealWidth());
        schema.setRealOffsetX(domainImage.getRealOffsetX());
        schema.setRealOffsetY(domainImage.getRealOffsetY());

        return schema;
    }
}
