
package com.example.demo.service;

import java.util.List;

import com.example.demo.dao.IUsersDao;
import com.example.demo.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService implements IUsersService {

    @Autowired
    private IUsersDao usersDao;
    
    @Override
	public List<User> getUsers(){
		return usersDao.getUsers();
    }
    
}