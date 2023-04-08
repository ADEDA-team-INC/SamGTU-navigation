package org.adeda.samgtu_navigation.map.repository;

import org.adeda.samgtu_navigation.map.model.MapObject;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MapObjectRepository extends CrudRepository<MapObject, Integer> {
    MapObject findByObjectId(Integer id);
}
