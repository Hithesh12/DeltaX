package com.example.music.service;

import java.util.List;

import com.example.music.model.User;


public interface UserService {

	public List<User> getAllUsers();
	
	public User getUser(int id);
}
