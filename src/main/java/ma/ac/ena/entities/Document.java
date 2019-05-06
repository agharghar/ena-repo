package ma.ac.ena.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties
public class Document implements Serializable{

	@Id
	private String ref ; 
	
	private String type ;
	private String titre ; 
	private Date date_creation ; 
	private Date date_mise_ajour ; 
	private String commentaire ; 
	private String chemin ; 
	
	@OneToMany(mappedBy="groupePartage_document_PK.document")
	private Set<GroupePartage_Document> groupePartage_Documents;
	
	@OneToMany(mappedBy="envoie_PK.document")
	private Set<Envoie >Envoie ; 
	
	
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employee ; 
	
	
	@OneToMany(mappedBy="document")
	private Set<Version> version ;
	
	@ManyToMany(mappedBy="documents")
	private Set<Categorie> categories ; 
	
	@ManyToMany(mappedBy="documents")
	private Set<Dossier> dossiers ;

	public Document() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
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

	public Set<GroupePartage_Document> getGroupePartage_Documents() {
		return groupePartage_Documents;
	}

	public void setGroupePartage_Documents(Set<GroupePartage_Document> groupePartage_Documents) {
		this.groupePartage_Documents = groupePartage_Documents;
	}

	public String getChemin() {
		return chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	public Set<Envoie> getEnvoie() {
		return Envoie;
	}

	public void setEnvoie(Set<Envoie> envoie) {
		Envoie = envoie;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Set<Version> getVersion() {
		return version;
	}

	public void setVersion(Set<Version> version) {
		this.version = version;
	}

	public Set<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(Set<Categorie> categories) {
		this.categories = categories;
	}

	public Set<Dossier> getDossiers() {
		return dossiers;
	}

	public void setDossiers(Set<Dossier> dossiers) {
		this.dossiers = dossiers;
	}
	
	


	
}
