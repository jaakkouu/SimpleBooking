package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
	User findByEmail(String email);
	User findUserByUsername(String username);
	List<User> findByRole_AuthorityNot(String role);
}