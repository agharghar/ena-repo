package ma.ac.ena.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "permission")
public class Permission {
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPermission;
	private String operation;

	// @ManyToMany
	// @JoinTable(name = "ATTRIBUER")
	// private Collection<Role> role;
	//
	// @ManyToMany
	// @JoinTable(name = "ATTRIBUER")
	// private Collection<Forms> forms;

	// getters and setters
	public int getIdPermission() {
		return idPermission;
	}

	public void setIdPermission(int idPermission) {
		this.idPermission = idPermission;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	// public Collection<Role> getRole() {
	// return role;
	// }
	//
	// public void setRole(Collection<Role> role) {
	// this.role = role;
	// }
	//
	// public Collection<Forms> getForms() {
	// return forms;
	// }
	//
	// public void setForms(Collection<Forms> forms) {
	// this.forms = forms;
	// }

	// constructors
	public Permission(String operation) {
		super();
		this.operation = operation;
	}

	public Permission() {
		super();
	}

}
