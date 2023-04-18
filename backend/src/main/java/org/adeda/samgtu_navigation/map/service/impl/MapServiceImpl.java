package org.adeda.samgtu_navigation.map.service.impl;

import org.adeda.samgtu_navigation.localization.enums.SupportedLanguage;
import org.adeda.samgtu_navigation.map.model.MapBuilding;
import org.adeda.samgtu_navigation.map.model.MapDomain;
import org.adeda.samgtu_navigation.map.model.MapObject;
import org.adeda.samgtu_navigation.map.model.OutdoorObject;
import org.adeda.samgtu_navigation.map.repository.MapBuildingRepository;
import org.adeda.samgtu_navigation.map.repository.MapDomainRepository;
import org.adeda.samgtu_navigation.map.repository.MapObjectRepository;
import org.adeda.samgtu_navigation.map.repository.OutdoorObjectRepository;
import org.adeda.samgtu_navigation.map.schema.MapSearchResult;
import org.adeda.samgtu_navigation.map.service.MapSchemasFactory;
import org.adeda.samgtu_navigation.map.service.MapService;
import org.springframework.stereotype.Service;

@Service
public class MapServiceImpl implements MapService {
    private final MapBuildingRepository buildingRepository;
    private final MapObjectRepository mapObjectRepository;
    private final OutdoorObjectRepository outdoorObjectRepository;
    private final MapSchemasFactory schemasFactory;

    public MapServiceImpl(
        MapBuildingRepository buildingRepository,
        MapObjectRepository mapObjectRepository,
        OutdoorObjectRepository outdoorObjectRepository,
        MapSchemasFactory schemasFactory
    ) {
        this.buildingRepository = buildingRepository;
        this.mapObjectRepository = mapObjectRepository;
        this.outdoorObjectRepository = outdoorObjectRepository;
        this.schemasFactory = schemasFactory;
    }

    @Override
    public MapSearchResult search(String query, SupportedLanguage language, int limit) {
        var result = new MapSearchResult();

        result.setMapBuildings(
            buildingRepository.search(query, limit, 0).stream().map(
                b -> schemasFactory.getBuildingSchema(b, language)
            ).toList()
        );
        result.setMapObjects(
            mapObjectRepository.search(query, limit, 0).stream().map(
                o -> schemasFactory.getObjectInfo(o, language)
            ).toList()
        );
        result.setOutdoorObjects(
            outdoorObjectRepository.search(query, limit, 0).stream().map(
                o -> schemasFactory.getOutdoorObjectSchema(o, language)
            ).toList()
        );

        return result;
    }
}
