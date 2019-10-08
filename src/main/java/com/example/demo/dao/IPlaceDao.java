package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Place;

public interface IPlaceDao {
    List<Place> getPlaces();
    List<Place> getPlacesByUserId(long userId);
    Place getPlaceById(int placeId);
    /*
    void addPlace(Place place);
    void updatePlace(Place place);
    void deletePlace(int placeId);
    */
}
 