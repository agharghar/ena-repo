package ma.ac.ena.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Envoie implements Serializable{

	@Id 
	private Envoie_PK envoie_PK  ; 
	
	private Date date_envoie ; 
	private Date date_reception ;
	@Column(columnDefinition="tinyint(1) default 0")
	private Boolean lu ; 
	
	
	public Envoie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Envoie(Envoie_PK envoie_PK, Date date_envoie, Date date_reception, Boolean lu) {
		super();
		this.envoie_PK = envoie_PK;
		this.date_envoie = date_envoie;
		this.date_reception = date_reception;
		this.lu = lu;
	}



	public Envoie_PK getEnvoie_PK() {
		return envoie_PK;
	}
	public void setEnvoie_PK(Envoie_PK envoie_PK) {
		this.envoie_PK = envoie_PK;
	}
	public Date getDate_envoie() {
		return date_envoie;
	}
	public void setDate_envoie(Date date_envoie) {
		this.date_envoie = date_envoie;
	}
	public Date getDate_reception() {
		return date_reception;
	}
	public void setDate_reception(Date date_reception) {
		this.date_reception = date_reception;
	}



	public Boolean getLu() {
		return lu;
	}



	public void setLu(Boolean lu) {
		this.lu = lu;
	} 
	
	
	
	
}
