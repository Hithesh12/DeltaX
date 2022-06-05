package com.example.music.service;

import java.util.List;

import com.example.music.model.User;


public interface UserService {

	public List<User> getAllUsers();
	
	public User getUser(int id);
	
	public User addUser(User user);
	
	public User updateUser(int id, User user);
	
	public void deleteUser(int id);
}
