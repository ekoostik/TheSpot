package thespot.services;

import thespot.entities.User;

public interface AuthService {
	
	public User register(User user);
	public User getUserByUsername(String username);

}
