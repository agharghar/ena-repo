package ma.ac.ena.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ma.ac.ena.entities.User;
import ma.ac.ena.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/addUser")
	public User saveUser(User u) {
		// User u1 = userRepository.findByUsernameAndPassword(u.getUsername(),
		// new BCryptPasswordEncoder().encode(u.getPassword()));
		//
		// if (u1 != null) {
		// System.out.println("oui");
		// } else {
		// System.out.println("no");
		// }

		u.setPassword(new BCryptPasswordEncoder().encode(u.getPassword()));
		return userService.save(u);
	}

	@RequestMapping(value = "/findUsers")
	public List<User> findUsers() {
		return userRepository.findAll();
	}

}
