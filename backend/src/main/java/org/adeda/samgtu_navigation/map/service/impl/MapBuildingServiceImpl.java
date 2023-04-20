package org.adeda.samgtu_navigation.map.service.impl;

import org.adeda.samgtu_navigation.core.exception.EntityDependsException;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.map.model.MapBuilding;
import org.adeda.samgtu_navigation.map.model.MapEntityInfo;
import org.adeda.samgtu_navigation.map.repository.MapBuildingRepository;
import org.adeda.samgtu_navigation.map.schema.map_building.MapBuildingCreateSchema;
import org.adeda.samgtu_navigation.map.service.MapBuildingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MapBuildingServiceImpl implements MapBuildingService {
    private final MapBuildingRepository repository;

    public MapBuildingServiceImpl(MapBuildingRepository repository) {
        this.repository = repository;
    }

    @Override
    public MapBuilding create(MapBuildingCreateSchema schema) {
        var building = new MapBuilding(
            schema.getLatitude(),
            schema.getLongitude(),
            new MapEntityInfo(schema.getInfo()),
            Set.of()
        );

        return repository.save(building);
    }

    @Override
    public List<MapBuilding> getAll(Pageable pageable) {
        return repository.findAll(pageable).toList();
    }

    @Override
    public Optional<MapBuilding> getById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public MapBuilding updateById(Integer id, MapBuildingCreateSchema schema) throws NotFoundException {
        var building = repository.findById(id).orElse(null);
        if (building == null) {
            throw new NotFoundException("MapBuilding with given id was not found");
        }

        building.setLatitude(schema.getLatitude());
        building.setLongitude(schema.getLongitude());
        building.setInfo(new MapEntityInfo(schema.getInfo()));

        return repository.save(building);
    }

    @Override
    public void deleteById(Integer id) throws NotFoundException, EntityDependsException {
        var building = repository.findById(id).orElse(null);
        if (building == null) {
            throw new NotFoundException("MapBuilding with given id was not found");
        }

        if (!building.getDomains().isEmpty()) {
            throw new EntityDependsException("MapBuilding depends on MapDomain");
        }

        repository.delete(building);
    }
}
