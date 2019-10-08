package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.User;
import com.example.demo.model.UserRowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UsersDao implements IUsersDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<User> getUsers() {
        String sql = "SELECT * FROM users";
		RowMapper<User> rowMapper = new UserRowMapper();
		return jdbcTemplate.query(sql, rowMapper);
    }

}