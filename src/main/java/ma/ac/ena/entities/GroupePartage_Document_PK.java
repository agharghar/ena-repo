package ma.ac.ena.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class GroupePartage_Document_PK implements Serializable{

	@ManyToOne
	@JoinColumn(name="groupePartage_id")
	private GroupePartage groupePartage ; 
	
	
	@ManyToOne
	@JoinColumn(name="document_id") 
	private Document document ;


	public GroupePartage_Document_PK() {
		super();
		// TODO Auto-generated constructor stub
	}


	public GroupePartage getGroupePartage() {
		return groupePartage;
	}


	public void setGroupePartage(GroupePartage groupePartage) {
		this.groupePartage = groupePartage;
	}


	public Document getDocument() {
		return document;
	}


	public void setDocument(Document document) {
		this.document = document;
	} 
	
	
	
	
	
}
