package com.example.music.DAO;

import java.util.List;

import com.example.music.model.User;

public interface UserServiceDAO {

public List<User> getAllUsers();
	
	public User getUser(int id);
	
}
