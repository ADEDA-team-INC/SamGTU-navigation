package org.adeda.samgtu_navigation.map.schema.map_domain;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.adeda.samgtu_navigation.map.model.DomainImage;
import org.hibernate.validator.constraints.URL;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    public DomainImageSchema(DomainImage domainImage) {
        this.url = domainImage.getUrl();
        this.width = domainImage.getWidth();
        this.offsetX = domainImage.getOffset().getX();
        this.offsetY = domainImage.getOffset().getY();
    }
}
