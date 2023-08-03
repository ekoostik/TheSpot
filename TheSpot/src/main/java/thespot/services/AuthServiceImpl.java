package thespot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import thespot.entities.User;
import thespot.repositories.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public User register(User user) {

//		String encripted = encoder.encode(user.getPassword());
//		user.setPassword(encripted);
//		user.setEnabled(true);
//		user.setRole("standard");

		return userRepo.saveAndFlush(user);
	}

	@Override
	public User getUserByUsername(String username) {

		return userRepo.findByUsername(username);
	}

}
