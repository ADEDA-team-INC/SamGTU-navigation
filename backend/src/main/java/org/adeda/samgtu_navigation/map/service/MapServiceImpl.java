package org.adeda.samgtu_navigation.map.service;

import org.adeda.samgtu_navigation.map.repository.MapBuildingRepository;
import org.adeda.samgtu_navigation.map.repository.MapDomainRepository;
import org.adeda.samgtu_navigation.map.schema.MapBuildingSchema;
import org.adeda.samgtu_navigation.map.schema.MapDomainSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MapServiceImpl implements MapService{
    private final MapBuildingRepository buildingRepository;
    private final MapDomainRepository domainRepository;

    public MapServiceImpl(MapBuildingRepository buildingRepository, MapDomainRepository domainRepository) {
        this.buildingRepository = buildingRepository;
        this.domainRepository = domainRepository;
    }

    @Override
    public Optional<MapBuildingSchema> getBuildingById(Integer id) {
        return buildingRepository.findById(id).map(MapBuildingSchema::new);
    }

    @Override
    public Optional<MapDomainSchema> getDomainById(Integer id) {
        return domainRepository.findById(id).map(MapDomainSchema::new);
    }
}
