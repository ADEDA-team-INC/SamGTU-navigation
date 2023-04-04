package org.adeda.samgtu_navigation.map.service;

import org.adeda.samgtu_navigation.map.repository.MapBuildingRepository;
import org.adeda.samgtu_navigation.map.repository.MapDomainRepository;
import org.adeda.samgtu_navigation.map.repository.OutdoorObjectRepository;
import org.adeda.samgtu_navigation.map.schema.MapBuildingSchema;
import org.adeda.samgtu_navigation.map.schema.MapDomainSchema;
import org.adeda.samgtu_navigation.map.schema.OutdoorObjectSchema;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MapServiceImpl implements MapService {
    private final MapBuildingRepository buildingRepository;
    private final MapDomainRepository domainRepository;
    private final OutdoorObjectRepository outdoorObjectRepository;

    public MapServiceImpl(
        MapBuildingRepository buildingRepository,
        MapDomainRepository domainRepository,
        OutdoorObjectRepository outdoorObjectRepository
    ) {
        this.buildingRepository = buildingRepository;
        this.domainRepository = domainRepository;
        this.outdoorObjectRepository = outdoorObjectRepository;
    }

    @Override
    public List<MapBuildingSchema> getAllBuildings(int size, int page) {
        return buildingRepository.findAll(PageRequest.of(page, size)).map(MapBuildingSchema::new).toList();
    }

    @Override
    public Optional<MapBuildingSchema> getBuildingById(Integer id) {
        return buildingRepository.findById(id).map(MapBuildingSchema::new);
    }

    @Override
    public Optional<MapDomainSchema> getDomainById(Integer id) {
        return domainRepository.findById(id).map(MapDomainSchema::new);
    }

    @Override
    public List<OutdoorObjectSchema> getAllOutdoorObjects(int size, int page) {
        return outdoorObjectRepository.findAll(PageRequest.of(page, size)).map(OutdoorObjectSchema::new).toList();
    }
}
