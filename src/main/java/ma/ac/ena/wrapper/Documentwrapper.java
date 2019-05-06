package ma.ac.ena.wrapper;

import java.io.Serializable;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ma.ac.ena.entities.Categorie;
import ma.ac.ena.entities.Document;
import ma.ac.ena.entities.Version;

@Component
public class Documentwrapper implements Serializable{
	
	
	private Document document  ;
	private Categorie categorie ; 
	private Version version ;
	
	
	public Documentwrapper() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Documentwrapper(Document document, Categorie categorie, Version version) {
		super();
		this.document = document;
		this.categorie = categorie;
		this.version = version;
	}




	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Version getVersion() {
		return version;
	}
	public void setVersion(Version version) {
		this.version = version;
	} 
	
	
	

}
