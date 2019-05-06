package ma.ac.ena.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee_GroupePartage implements Serializable{

	@Id 
	private Employee_GroupePartage_PK employee_GroupePartage_PK  ;
	
	private Date date_creation ; 
	
	private int nbr_membre  ;

	public Employee_GroupePartage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee_GroupePartage_PK getEmployee_GroupePartage_PK() {
		return employee_GroupePartage_PK;
	}

	public void setEmployee_GroupePartage_PK(Employee_GroupePartage_PK employee_GroupePartage_PK) {
		this.employee_GroupePartage_PK = employee_GroupePartage_PK;
	}

	public Date getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	public int getNbr_membre() {
		return nbr_membre;
	}

	public void setNbr_membre(int nbr_membre) {
		this.nbr_membre = nbr_membre;
	} 
	
	
	
	
	
	
	
	
}
