package ma.ac.ena.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties
public class Version implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	
	private String libelle_version ; 
	private Date date_ajout ; 
	private String commentaire ;
	
	@ManyToOne
	@JoinColumn(name="document_id")
	private Document document ; 
	
	
	public Version() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLibelle_version() {
		return libelle_version;
	}


	public void setLibelle_version(String libelle_version) {
		this.libelle_version = libelle_version;
	}


	public Date getDate_ajout() {
		return date_ajout;
	}


	public void setDate_ajout(Date date_ajout) {
		this.date_ajout = date_ajout;
	}


	public String getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}


	public Document getDocument() {
		return document;
	}


	public void setDocument(Document document) {
		this.document = document;
	} 
	
	
	
	
}
