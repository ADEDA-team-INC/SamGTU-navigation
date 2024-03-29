package org.adeda.samgtu_navigation.map.service.impl;

import jakarta.annotation.Nullable;
import org.adeda.samgtu_navigation.core.exception.NotFoundException;
import org.adeda.samgtu_navigation.map.enums.OutdoorObjectType;
import org.adeda.samgtu_navigation.map.model.MapEntityInfo;
import org.adeda.samgtu_navigation.map.model.OutdoorObject;
import org.adeda.samgtu_navigation.map.repository.OutdoorObjectRepository;
import org.adeda.samgtu_navigation.map.schema.outdoor_object.OutdoorObjectCreateSchema;
import org.adeda.samgtu_navigation.map.service.OutdoorObjectService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OutdoorObjectServiceImpl implements OutdoorObjectService {
    private final OutdoorObjectRepository repository;

    public OutdoorObjectServiceImpl(OutdoorObjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public OutdoorObject create(OutdoorObjectCreateSchema schema) {
        var outdoorObj = new OutdoorObject(
            schema.getType(),
            schema.getLatitude(),
            schema.getLongitude(),
            new MapEntityInfo(schema.getInfo())
        );

        return repository.save(outdoorObj);
    }

    @Override
    public List<OutdoorObject> getAll(@Nullable OutdoorObjectType type, Pageable pageable) {
        return repository.findAll(type, pageable);
    }

    @Override
    public Optional<OutdoorObject> getById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public OutdoorObject updateById(Integer id, OutdoorObjectCreateSchema schema) throws NotFoundException {
        var outdoorObj = repository.findById(id).orElse(null);
        if (outdoorObj == null) {
            throw new NotFoundException("OutdoorObject with given id was not found");
        }

        outdoorObj.setType(schema.getType());
        outdoorObj.setLatitude(schema.getLatitude());
        outdoorObj.setLongitude(schema.getLongitude());
        outdoorObj.setInfo(new MapEntityInfo(schema.getInfo()));

        return repository.save(outdoorObj);
    }

    @Override
    public void deleteById(Integer id) throws NotFoundException {
        var outdoorObj = repository.findById(id).orElse(null);
        if (outdoorObj == null) {
            throw new NotFoundException("OutdoorObject with given id was not found");
        }

        repository.delete(outdoorObj);
    }
}
