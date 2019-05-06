package ma.ac.ena.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Employee implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ; 
	
	private String matricule  ;
	private Date date_recrutement  ; 
	private String nom ; 
	private String prenom  ;
	@OneToMany(mappedBy="employee")
	private Set<Document> documents ;
	
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user ;
	
	@OneToMany(mappedBy="employee_GroupePartage_PK.employee")
	private Set<Employee_GroupePartage > employee_GroupePartage ; 
	
	@OneToMany(mappedBy="envoie_PK.employee")
	private Set<Envoie> envoies ;
	


	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employee(int id, String matricule, Date date_recrutement, User user) {
		super();
		this.id = id;
		this.matricule = matricule;
		this.date_recrutement = date_recrutement;
		this.user = user;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMatricule() {
		return matricule;
	}


	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}


	public Date getDate_recrutement() {
		return date_recrutement;
	}


	public void setDate_recrutement(Date date_recrutement) {
		this.date_recrutement = date_recrutement;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Set<Employee_GroupePartage> getEmployee_GroupePartage() {
		return employee_GroupePartage;
	}


	public void setEmployee_GroupePartage(Set<Employee_GroupePartage> employee_GroupePartage) {
		this.employee_GroupePartage = employee_GroupePartage;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public Set<Document> getDocuments() {
		return documents;
	}


	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}


	public Set<Envoie> getEnvoies() {
		return envoies;
	}


	public void setEnvoies(Set<Envoie> envoies) {
		this.envoies = envoies;
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
