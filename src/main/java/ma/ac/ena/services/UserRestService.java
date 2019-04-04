package ma.ac.ena.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.ac.ena.dao.RoleRepository;
import ma.ac.ena.dao.UserRepository;
import ma.ac.ena.entities.Role;
import ma.ac.ena.entities.User;

@RestController
@Secured(value = { "ROLE_ADMIN" })
public class UserRestService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	// @Autowired
	// private PermissionRepository permissionRepository;
	// // @Autowired
	// // private FormsRepository formsRepository;

	@RequestMapping(value = "/addRole")
	public Role saveRole(Role r) {
		return roleRepository.save(r);
	}

	@RequestMapping(value = "/findRoles")
	public List<Role> findRoles() {
		return roleRepository.findAll();
	}

	@RequestMapping(value = "/addRoleToUser") // probleme
	public User addRoleToUser(String username, String role) {
		// ******************method 1*******************

		// User u = userRepository.findOne(username);
		// Role r = roleRepository.findOne(role);

		// ******************fin method 1*******************

		// ******************method 2*******************
		User u = null;
		Role r = null;
		Optional<User> usernames = this.userRepository.findById(username);
		if (usernames.isPresent()) {
			u = usernames.get();
		}
		Optional<Role> roles = this.roleRepository.findById(role);
		if (roles.isPresent()) {
			r = roles.get();
		}

		// ******************fin method 2*******************

		// ******************method 3*******************

		// User u = userRepository.getOne(username);
		// Role r = roleRepository.getOne(role);

		// ******************fin method 3*******************

		// ******************method 4*******************
		// *specifier une fonction findByUsername() et findByRole()*

		// User u = userRepository.findByUsername(username);
		// Role r = roleRepository.findByRole(role);

		// ******************fin method 4*******************

		u.getRoles().add(r);
		userRepository.save(u);
		return u;
	}

	// @RequestMapping(value = "/addPermission")
	// public Permission savePermission(Permission u) {
	// return permissionRepository.save(u);
	// }
	//
	// @RequestMapping(value = "/findPermissions")
	// public List<Permission> findPermissions() {
	// return permissionRepository.findAll();
	// }
}
