package org.adeda.samgtu_navigation.map.service;

import org.adeda.samgtu_navigation.map.model.MapBuilding;
import org.adeda.samgtu_navigation.map.model.MapDomain;
import org.adeda.samgtu_navigation.map.model.MapObject;
import org.adeda.samgtu_navigation.map.model.OutdoorObject;
import org.adeda.samgtu_navigation.map.repository.MapBuildingRepository;
import org.adeda.samgtu_navigation.map.repository.MapDomainRepository;
import org.adeda.samgtu_navigation.map.repository.MapObjectRepository;
import org.adeda.samgtu_navigation.map.repository.OutdoorObjectRepository;
import org.adeda.samgtu_navigation.map.schema.MapSearchResult;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MapServiceImpl implements MapService {
    private final MapBuildingRepository buildingRepository;
    private final MapDomainRepository domainRepository;
    private final MapObjectRepository mapObjectRepository;
    private final OutdoorObjectRepository outdoorObjectRepository;

    public MapServiceImpl(
        MapBuildingRepository buildingRepository,
        MapDomainRepository domainRepository,
        MapObjectRepository mapObjectRepository,
        OutdoorObjectRepository outdoorObjectRepository
    ) {
        this.buildingRepository = buildingRepository;
        this.domainRepository = domainRepository;
        this.mapObjectRepository = mapObjectRepository;
        this.outdoorObjectRepository = outdoorObjectRepository;
    }

    @Override
    public List<MapBuilding> getBuildings(int size, int page) {
        return buildingRepository.findAll(PageRequest.of(page, size)).toList();
    }

    @Override
    public Optional<MapBuilding> getBuildingById(Integer id) {
        return buildingRepository.findById(id);
    }

    @Override
    public Optional<MapDomain> getDomainById(Integer id) {
        return domainRepository.findById(id);
    }

    @Override
    public Optional<MapObject> getObjectById(Integer id) {
        return mapObjectRepository.findById(id);
    }

    @Override
    public List<OutdoorObject> getOutdoorObjects(int size, int page) {
        return outdoorObjectRepository.findAll(PageRequest.of(page, size)).toList();
    }

    @Override
    public MapSearchResult search(String query) {
        throw new UnsupportedOperationException();
    }
}
