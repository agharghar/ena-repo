package ma.ac.ena.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Embeddable
public class Envoie_PK implements Serializable{

	@ManyToOne
	@JoinColumn(name="document_id")
	private Document document ;
	
	
	@ManyToOne
	@JoinColumn(name="destinataire_id")
	private Employee employee ;


	public Envoie_PK() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Envoie_PK(Document document, Employee employee) {
		super();
		this.document = document;
		this.employee = employee;
	}



	public Document getDocument() {
		return document;
	}


	public void setDocument(Document document) {
		this.document = document;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	} 
	
	
	
	
	
	
	
}
