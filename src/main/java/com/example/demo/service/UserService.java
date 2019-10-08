
package com.example.demo.service;

import java.util.List;

import com.example.demo.dao.IUserDao;
import com.example.demo.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;
    
    @Override
	public User getUserByUsername(String username){
		return userDao.getUserByUsername(username);
    }

}