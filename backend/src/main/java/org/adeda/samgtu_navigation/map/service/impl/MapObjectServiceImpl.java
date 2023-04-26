package org.adeda.samgtu_navigation.map.service.impl;

import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.map.model.MapEntityInfo;
import org.adeda.samgtu_navigation.map.model.MapObject;
import org.adeda.samgtu_navigation.map.repository.MapDomainRepository;
import org.adeda.samgtu_navigation.map.repository.MapObjectRepository;
import org.adeda.samgtu_navigation.map.schema.map_object.BoundingBoxSchema;
import org.adeda.samgtu_navigation.map.schema.map_object.MapObjectCreateSchema;
import org.adeda.samgtu_navigation.map.service.MapObjectService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MapObjectServiceImpl implements MapObjectService {
    private final MapObjectRepository repository;
    private final MapDomainRepository domainRepository;

    public MapObjectServiceImpl(
        MapObjectRepository repository,
        MapDomainRepository domainRepository
    ) {
        this.repository = repository;
        this.domainRepository = domainRepository;
    }

    @Override
    public MapObject create(Integer domainId, MapObjectCreateSchema schema) throws NotFoundException {
        var domain = domainRepository.findById(domainId).orElse(null);
        if (domain == null) {
            throw new NotFoundException("MapDomain with given id was not found");
        }

        var mapObject = new MapObject(
            domain,
            schema.getType(),
            new MapEntityInfo(schema.getInfo()),
            schema.getBboxes().stream().map(BoundingBoxSchema::asRect).toList()
        );

        return repository.save(mapObject);
    }

    @Override
    public Optional<MapObject> getById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public MapObject updateById(Integer id, MapObjectCreateSchema schema) throws NotFoundException {
        var mapObject = repository.findById(id).orElse(null);
        if (mapObject == null) {
            throw new NotFoundException("MapObject with given id was not found");
        }

        mapObject.setType(schema.getType());
        mapObject.setInfo(new MapEntityInfo(schema.getInfo()));
        mapObject.setBoundingBoxes(
            schema.getBboxes().stream().map(BoundingBoxSchema::asRect).toList()
        );

        return repository.save(mapObject);
    }

    @Override
    public void deleteById(Integer id) throws NotFoundException {
        var mapObject = repository.findById(id).orElse(null);
        if (mapObject == null) {
            throw new NotFoundException("MapObject with given id was not found");
        }

        repository.delete(mapObject);
    }
}
