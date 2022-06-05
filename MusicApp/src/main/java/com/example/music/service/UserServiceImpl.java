package com.example.music.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.music.DAO.UserServiceDAO;
import com.example.music.model.User;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	UserServiceDAO userServiceDAO;
	
	@Override
	public List<User> getAllUsers() {
		List<User> users =userServiceDAO.getAllUsers();
		return users;
	}

	@Override
	public User getUser(int id) {
		User user = userServiceDAO.getUser(id);
		return user;
	}
}
