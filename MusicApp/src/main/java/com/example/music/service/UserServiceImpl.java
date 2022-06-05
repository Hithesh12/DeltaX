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

	@Override
	public User addUser(User user) {
		userServiceDAO.addUser(user);
		return user;
	}

	@Override
	public User updateUser(int id, User user) {
		userServiceDAO.updateUser(id, user);
		return user;
	}

	@Override
	public void deleteUser(int id) {
		userServiceDAO.deleteUser(id);		
	}
}
