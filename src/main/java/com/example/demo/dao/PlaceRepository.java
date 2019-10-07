package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.Place;

public interface PlaceRepository extends CrudRepository<Place, Long> {
    Place findByName(String name);
}