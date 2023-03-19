package org.adeda.samgtu_navigation.map.service;

import org.adeda.samgtu_navigation.map.repository.MapBuildingRepository;
import org.adeda.samgtu_navigation.map.repository.MapDomainRepository;
import org.adeda.samgtu_navigation.map.schema.MapBuildingSchema;
import org.adeda.samgtu_navigation.map.schema.MapDomainSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapServiceImpl implements MapService{

    @Autowired
    private MapBuildingRepository buildingRepository;
    @Autowired
    private MapDomainRepository domainRepository;

    @Override
    public MapBuildingSchema getBuildingById(Integer id) {
        return buildingRepository.findById(id).map(MapBuildingSchema::createFromModel).orElse(null);
    }

    @Override
    public MapDomainSchema getDomainById(Integer id) {
        return domainRepository.findById(id).map(MapDomainSchema::createFromModel).orElse(null);
    }
}
