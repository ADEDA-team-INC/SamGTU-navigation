package org.adeda.samgtu_navigation.map.service;

import org.adeda.samgtu_navigation.localization.enums.SupportedLanguage;
import org.adeda.samgtu_navigation.map.model.MapBuilding;
import org.adeda.samgtu_navigation.map.model.MapDomain;
import org.adeda.samgtu_navigation.map.model.MapObject;
import org.adeda.samgtu_navigation.map.model.OutdoorObject;
import org.adeda.samgtu_navigation.map.schema.map_building.MapBuildingInfo;
import org.adeda.samgtu_navigation.map.schema.map_building.MapBuildingSchema;
import org.adeda.samgtu_navigation.map.schema.map_domain.MapDomainSchema;
import org.adeda.samgtu_navigation.map.schema.map_object.DetailedMapObject;
import org.adeda.samgtu_navigation.map.schema.map_object.MapObjectInfo;
import org.adeda.samgtu_navigation.map.schema.map_object.MapObjectSchema;
import org.adeda.samgtu_navigation.map.schema.outdoor_object.OutdoorObjectSchema;

public interface MapSchemasFactory {
    MapBuildingSchema getBuildingSchema(MapBuilding building, SupportedLanguage language);

    MapBuildingInfo getBuildingInfo(MapBuilding building, SupportedLanguage language);

    MapDomainSchema getDomainSchema(MapDomain domain, SupportedLanguage language);

    MapObjectSchema getObjectSchema(MapObject mapObject, SupportedLanguage language);

    MapObjectInfo getObjectInfo(MapObject mapObject, SupportedLanguage language);

    DetailedMapObject getDetailedMapObject(MapObject mapObject, SupportedLanguage language);

    OutdoorObjectSchema getOutdoorObjectSchema(OutdoorObject outdoorObject, SupportedLanguage language);
}
