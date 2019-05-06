package ma.ac.ena.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class GroupePartage implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ; 
	
	private String nom ; 
	private String description ; 
	
	
	@OneToMany(mappedBy="employee_GroupePartage_PK.groupePartage")
	private Set<Employee_GroupePartage> employee_GroupePartage ;

	@OneToMany(mappedBy="groupePartage_document_PK.groupePartage")
	private Set<GroupePartage_Document> groupePartage_Documents;
	
	public GroupePartage() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Set<Employee_GroupePartage> getEmployee_GroupePartage() {
		return employee_GroupePartage;
	}


	public void setEmployee_GroupePartage(Set<Employee_GroupePartage> employee_GroupePartage) {
		this.employee_GroupePartage = employee_GroupePartage;
	}



	
	
	
}
