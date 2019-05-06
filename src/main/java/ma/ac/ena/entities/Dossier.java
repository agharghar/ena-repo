package ma.ac.ena.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Dossier implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	private String commentaire ; 
	private String chemin ; 
	private String nom ;
	
	
	@ManyToMany
	@JoinTable(name="dossier_document" , joinColumns=@JoinColumn(name="dossier_id") , inverseJoinColumns=@JoinColumn(name="document_id"))
	private Set<Document> documents ; 
	
	@OneToMany(mappedBy="dossier_pere")
	private Set<Dossier> dossiers_fils ;
	
	
	@ManyToOne
	@JoinColumn(name="dossier_pere")
	private Dossier dossier_pere ; 
	
	
	public Dossier() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}


	public String getChemin() {
		return chemin;
	}


	public void setChemin(String chemin) {
		this.chemin = chemin;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	} 
	
	
	
	

}
