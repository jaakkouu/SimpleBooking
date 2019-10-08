package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Place;

public interface IPlaceService {
     List<Place> getPlaces();
     List<Place> getPlacesByUserId(long userId);
     Place getPlaceById(int placeId);

     /*
     boolean addPlace(Place place);
     void updatePlace(Place place);
     void deletePlace(int placeId);
     */
}
