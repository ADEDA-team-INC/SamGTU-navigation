package org.adeda.samgtu_navigation.map.service.impl;

import org.adeda.samgtu_navigation.core.exception.AlreadyExistsException;
import org.adeda.samgtu_navigation.core.exception.EntityDependsException;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.map.model.DomainImage;
import org.adeda.samgtu_navigation.map.model.MapDomain;
import org.adeda.samgtu_navigation.map.repository.MapBuildingRepository;
import org.adeda.samgtu_navigation.map.repository.MapDomainRepository;
import org.adeda.samgtu_navigation.map.schema.map_domain.MapDomainCreateSchema;
import org.adeda.samgtu_navigation.map.service.MapDomainService;
import org.adeda.samgtu_navigation.navigation.model.NavNode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MapDomainServiceImpl implements MapDomainService {
    private final MapDomainRepository repository;
    private final MapBuildingRepository buildingRepository;

    public MapDomainServiceImpl(
        MapDomainRepository repository,
        MapBuildingRepository buildingRepository
    ) {
        this.repository = repository;
        this.buildingRepository = buildingRepository;
    }

    @Override
    public MapDomain create(
        Integer buildingId, MapDomainCreateSchema schema
    ) throws NotFoundException, AlreadyExistsException {
        var building = buildingRepository.findById(buildingId).orElse(null);
        if (building == null) {
            throw new NotFoundException("MapBuilding with given id was not found");
        }

        if (building.getDomains().stream().anyMatch(
            d -> d.getOrdinalNumber().equals(schema.getOrdinalNumber())
        )) {
            throw new AlreadyExistsException("MapDomain with given ordinal number already exists");
        }

        var domain = new MapDomain(
            building,
            new DomainImage(schema.getImage()),
            schema.getOrdinalNumber(),
            Set.of()
        );

        return repository.save(domain);
    }

    @Override
    public Optional<MapDomain> getById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<NavNode> getNodes(Integer id) throws NotFoundException {
        if (!repository.existsById(id)) {
            throw new NotFoundException("MapDomain with given id was not found");
        }

        return repository.findNodes(id);
    }

    @Override
    public MapDomain updateById(
        Integer id, MapDomainCreateSchema schema
    ) throws NotFoundException, AlreadyExistsException {
        var domain = repository.findById(id).orElse(null);
        if (domain == null) {
            throw new NotFoundException("MapDomain with given id was not found");
        }

        if (!domain.getOrdinalNumber().equals(schema.getOrdinalNumber()) &&
            domain.getBuilding().getDomains().stream().anyMatch(
                d -> !d.equals(domain) && d.getOrdinalNumber().equals(schema.getOrdinalNumber())
            )
        ) {
            throw new AlreadyExistsException("MapDomain with given ordinal number already exists");
        }

        domain.setImage(new DomainImage(schema.getImage()));
        domain.setOrdinalNumber(schema.getOrdinalNumber());

        return repository.save(domain);
    }

    @Override
    public void deleteById(Integer id) throws NotFoundException, EntityDependsException {
        var domain = repository.findById(id).orElse(null);
        if (domain == null) {
            throw new NotFoundException("MapDomain with given id was not found");
        }

        if (!domain.getMapObjects().isEmpty()) {
            throw new EntityDependsException("MapDomain depends on MapObject");
        }

        repository.delete(domain);
    }
}
