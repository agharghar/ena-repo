package ma.ac.ena.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GroupePartage_Document {

	@Id
	private GroupePartage_Document_PK groupePartage_document_PK ; 
	
	private Date date_creation ; 
	private Date date_mise_ajour ; 
	private String commentaire  ;
	
	
	public GroupePartage_Document() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GroupePartage_Document_PK getGroupePartage_document_PK() {
		return groupePartage_document_PK;
	}
	public void setGroupePartage_document_PK(GroupePartage_Document_PK groupePartage_document_PK) {
		this.groupePartage_document_PK = groupePartage_document_PK;
	}
	public Date getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}
	public Date getDate_mise_ajour() {
		return date_mise_ajour;
	}
	public void setDate_mise_ajour(Date date_mise_ajour) {
		this.date_mise_ajour = date_mise_ajour;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	} 
	
	
	
}
