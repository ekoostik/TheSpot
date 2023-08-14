package com.thespot.services;

import com.thespot.entities.User;

public interface AuthService {
	public User register(User user);
	public User getUserByUsername(String username);

}
