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
    private Double width;

    @NotNull
    private Double offsetX;

    @NotNull
    private Double offsetY;

    public static DomainImageSchema createFromModel(DomainImage domainImage) {
        var schema = new DomainImageSchema();

        schema.setUrl(domainImage.getUrl());
        schema.setWidth(domainImage.getWidth());
        schema.setOffsetX(domainImage.getOffset().getX());
        schema.setOffsetY(domainImage.getOffset().getY());

        return schema;
    }
}
