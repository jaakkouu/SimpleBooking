package com.example.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class PlaceRowMapper implements RowMapper<Place> {
	@Override
	public Place mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Place(
            rs.getInt("userId"),
            rs.getString("name"),
            rs.getString("address"),
            rs.getString("largeDescription"),
            rs.getString("smallDescription")
        );
	}
} 