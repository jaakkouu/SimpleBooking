
package com.example.demo.service;

import java.util.List;

import com.example.demo.dao.IPlaceDao;
import com.example.demo.model.Place;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceService implements IPlaceService {

    @Autowired
    private IPlaceDao placeDao;
    
    @Override
	public List<Place> getPlaces(){
		return placeDao.getPlaces();
    }
    
    @Override
	public List<Place> getPlacesByUserId(long userId){
		return placeDao.getPlacesByUserId(userId);
    }
    
    @Override
    public Place getPlaceById(int placeId) {
        return placeDao.getPlaceById(placeId);
    }

}