package ma.ac.ena.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.ac.ena.dao.FormsRepository;
import ma.ac.ena.dao.PermissionRepository;
import ma.ac.ena.entities.Forms;
import ma.ac.ena.entities.Permission;

@RestController
@Secured(value = { "ROLE_ADMIN" })
public class PermissionRestService {
	@Autowired
	private PermissionRepository permissionRepository;
	@Autowired
	private FormsRepository formsRepository;

	@RequestMapping(value = "/addPermission")
	public Permission savePermission(Permission u) {
		return permissionRepository.save(u);
	}

	@RequestMapping(value = "/findPermissions")
	public List<Permission> findPermissions() {
		return permissionRepository.findAll();
	}

	@RequestMapping(value = "/addForms")
	public Forms saveForms(Forms r) {
		return formsRepository.save(r);
	}

	@RequestMapping(value = "/findForms")
	public List<Forms> findForms() {
		return formsRepository.findAll();
	}
}
