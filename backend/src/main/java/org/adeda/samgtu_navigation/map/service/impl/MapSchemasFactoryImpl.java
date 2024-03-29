package org.adeda.samgtu_navigation.map.service.impl;

import org.adeda.samgtu_navigation.localization.enums.SupportedLanguage;
import org.adeda.samgtu_navigation.localization.service.LocalizationService;
import org.adeda.samgtu_navigation.map.model.*;
import org.adeda.samgtu_navigation.map.schema.info.InfoSchema;
import org.adeda.samgtu_navigation.map.schema.map_building.MapBuildingSchema;
import org.adeda.samgtu_navigation.map.schema.map_domain.DomainImageSchema;
import org.adeda.samgtu_navigation.map.schema.map_domain.MapDomainSchema;
import org.adeda.samgtu_navigation.map.schema.map_object.BoundingBoxSchema;
import org.adeda.samgtu_navigation.map.schema.map_object.DetailedMapObject;
import org.adeda.samgtu_navigation.map.schema.map_object.MapObjectInfo;
import org.adeda.samgtu_navigation.map.schema.map_object.MapObjectSchema;
import org.adeda.samgtu_navigation.map.schema.outdoor_object.OutdoorObjectSchema;
import org.adeda.samgtu_navigation.map.service.MapSchemasFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MapSchemasFactoryImpl implements MapSchemasFactory {
    private final LocalizationService localizationService;

    public MapSchemasFactoryImpl(LocalizationService localizationService) {
        this.localizationService = localizationService;
    }

    @Override
    public MapBuildingSchema getBuildingSchema(MapBuilding building, SupportedLanguage language) {
        return new MapBuildingSchema(
            building.getId(),
            building.getLatitude(),
            building.getLongitude(),
            getInfoSchema(building.getInfo(), language),
            building.getDomains().stream().collect(
                Collectors.toMap(MapDomain::getOrdinalNumber, MapDomain::getId)
            )
        );
    }

    @Override
    public MapDomainSchema getDomainSchema(MapDomain domain, SupportedLanguage language) {
        return new MapDomainSchema(
            domain.getId(),
            new DomainImageSchema(domain.getImage()),
            domain.getMapObjects().stream().map(mapObject -> getObjectSchema(mapObject, language)).toList()
        );
    }

    @Override
    public MapObjectSchema getObjectSchema(MapObject mapObject, SupportedLanguage language) {
        return new MapObjectSchema(
            mapObject.getId(),
            mapObject.getType(),
            getInfoSchema(mapObject.getInfo(), language),
            mapObject.getBoundingBoxes().stream().map(BoundingBoxSchema::new).toList()
        );
    }

    @Override
    public MapObjectInfo getObjectInfo(MapObject mapObject, SupportedLanguage language) {
        return new MapObjectInfo(
            mapObject.getId(),
            mapObject.getType(),
            getInfoSchema(mapObject.getInfo(), language)
        );
    }

    @Override
    public DetailedMapObject getDetailedMapObject(MapObject mapObject, SupportedLanguage language) {
        return new DetailedMapObject(
            mapObject.getId(),
            mapObject.getDomain().getBuilding().getId(),
            mapObject.getDomain().getId(),
            mapObject.getType(),
            getInfoSchema(mapObject.getInfo(), language)
        );
    }

    @Override
    public OutdoorObjectSchema getOutdoorObjectSchema(OutdoorObject outdoorObject, SupportedLanguage language) {
        return new OutdoorObjectSchema(
            outdoorObject.getId(),
            outdoorObject.getType(),
            outdoorObject.getLatitude(),
            outdoorObject.getLongitude(),
            getInfoSchema(outdoorObject.getInfo(), language)
        );
    }

    private InfoSchema getInfoSchema(MapEntityInfo info, SupportedLanguage language) {
        var imagesUrls = info.getImagesUrls();
        List<String> images;
        if (imagesUrls.isBlank()) {
            images = List.of();
        } else {
            images = List.of(imagesUrls.split("( *\\n *)"));
        }

        return new InfoSchema(
            images,
            localizationService.getByKeySafe(info.getNameKey(), language),
            localizationService.getByKeySafe(info.getDescriptionKey(), language)
        );
    }
}
