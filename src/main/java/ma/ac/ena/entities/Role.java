package ma.ac.ena.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Role implements Serializable {
	@Id
	private String role;
	private String description;

	@ManyToMany
	@JoinTable(name = "ATTRIBUER")
	private Set<Permission> permission;

	@ManyToMany
	@JoinTable(name = "ATTRIBUER")
	private Set<Forms> forms;

	// constructors
	public Role() {
		super();
	}

	public Role(String role, String description) {
		super();
		this.role = role;
		this.description = description;
	}

	// getters and setters
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Permission> getPermission() {
		return permission;
	}

	public void setPermission(Set<Permission> permission) {
		this.permission = permission;
	}

	public Set<Forms> getForms() {
		return forms;
	}

	public void setForms(Set<Forms> forms) {
		this.forms = forms;
	}

}
