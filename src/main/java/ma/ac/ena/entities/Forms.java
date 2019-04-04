package ma.ac.ena.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "forms")
public class Forms {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idForms;
	private String type;

	// @ManyToMany
	// @JoinTable(name = "ATTRIBUER")
	// private Collection<Permission> permission;
	//
	// @ManyToMany
	// @JoinTable(name = "ATTRIBUER")
	// private Collection<Role> role;

	// getters and setters
	public int getIdForms() {
		return idForms;
	}

	public void setIdForms(int idForms) {
		this.idForms = idForms;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	// public Collection<Permission> getPermission() {
	// return permission;
	// }
	//
	// public void setPermission(Collection<Permission> permission) {
	// this.permission = permission;
	// }
	//
	// public Collection<Role> getRole() {
	// return role;
	// }
	//
	// public void setRole(Collection<Role> role) {
	// this.role = role;
	// }

	// Constructors
	public Forms(String type) {
		super();
		this.type = type;
	}

	public Forms() {
		super();
	}

}
