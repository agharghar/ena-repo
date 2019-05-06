package ma.ac.ena.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties
public class Categorie implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ; 
	
	private String libelle_categorie ; 
	private String commantaire ;
	
	@ManyToMany
	@JoinTable( name="document_categorie", 
	joinColumns=@JoinColumn(name= "categorie_id") , 
	inverseJoinColumns = @JoinColumn(name = "document_id") )
	private Set<Document> documents ; 
	
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLibelle_categorie() {
		return libelle_categorie;
	}


	public void setLibelle_categorie(String libelle_categorie) {
		this.libelle_categorie = libelle_categorie;
	}


	public String getCommantaire() {
		return commantaire;
	}


	public void setCommantaire(String commantaire) {
		this.commantaire = commantaire;
	}


	public Set<Document> getDocuments() {
		return documents;
	}


	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	} 
	
	
	public void setDocuments(Document document) {
		if(this.documents == null) {
			this.documents = new HashSet<>() ; 
		}
		this.documents.add(document);
	} 
	
}
