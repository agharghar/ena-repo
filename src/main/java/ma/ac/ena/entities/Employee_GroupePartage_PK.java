package ma.ac.ena.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Employee_GroupePartage_PK implements Serializable {

	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employee ; 
	
	@ManyToOne
	@JoinColumn(name="groupePartage_id")
	private GroupePartage groupePartage ;

	public Employee_GroupePartage_PK() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public GroupePartage getGroupePartage() {
		return groupePartage;
	}

	public void setGroupePartage(GroupePartage groupePartage) {
		this.groupePartage = groupePartage;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
