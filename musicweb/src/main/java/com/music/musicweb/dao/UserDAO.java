package com.music.musicweb.dao;

import com.music.musicweb.model.User;

public interface UserDAO {
	
	public boolean registerUser(User user);
	public boolean updateUser(User user);
	public User getUser(String username);

}
