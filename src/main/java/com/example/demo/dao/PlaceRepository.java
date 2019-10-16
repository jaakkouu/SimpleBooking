package com.example.demo.dao;

import java.sql.Date;
import java.util.List;

import com.example.demo.model.Place;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends CrudRepository<Place, Long> {
    Place findByPlaceUrl_Url(String url);
    Place findByUserIdAndId(Long userId, Long id);
    List<Place> findPlacesByUserId(Long userId);

}