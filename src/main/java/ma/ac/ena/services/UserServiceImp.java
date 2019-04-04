package ma.ac.ena.services;

import org.springframework.beans.factory.annotation.Autowired;

import ma.ac.ena.dao.UserRepository;
import ma.ac.ena.entities.User;

public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(User u) {
		return userRepository.save(u);
	}
}
