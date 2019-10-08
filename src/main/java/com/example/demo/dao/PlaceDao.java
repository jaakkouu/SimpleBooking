package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Place;
import com.example.demo.model.PlaceRowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class PlaceDao implements IPlaceDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Place> getPlaces() {
        String sql = "SELECT * FROM places";
		RowMapper<Place> rowMapper = new PlaceRowMapper();
		return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public List<Place> getPlacesByUserId(long userId) {
        String sql = "SELECT * FROM places WHERE userId = ?";
		RowMapper<Place> rowMapper = new PlaceRowMapper();
		return jdbcTemplate.query(sql, rowMapper, userId);
    }

    public Place getPlaceById(int placeId) {
        String sql = "SELECT * FROM places WHERE id = ?";
        RowMapper<Place> rowMapper = new BeanPropertyRowMapper<Place>(Place.class);
		Place place = jdbcTemplate.queryForObject(sql, rowMapper, placeId);
		return place;
    }

    /*

    

    public void addPlace() {

    }
    
    public void updatePlace() {

    }
    
    public void deletePlace() {

    }

    */

}