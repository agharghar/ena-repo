package ma.ac.ena.services;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

import ma.ac.ena.dao.CategorieRepository;
import ma.ac.ena.dao.DocumentRepository;
import ma.ac.ena.dao.EmployeeRepository;
import ma.ac.ena.dao.EnvoieRepository;
import ma.ac.ena.dao.VersionRepository;
import ma.ac.ena.entities.Categorie;
import ma.ac.ena.entities.Document;
import ma.ac.ena.entities.Employee;
import ma.ac.ena.entities.Envoie;
import ma.ac.ena.entities.Envoie_PK;
import ma.ac.ena.entities.User;
import ma.ac.ena.entities.Version;
import ma.ac.ena.wrapper.Documentwrapper;

@Service
public class DocumentwrapperServiceImpl implements DocumentwrapperService{

	
	@Autowired
	private HttpSession session ; 
	@Autowired
	private EmployeeRepository employeeRepository ; 
	@Autowired
	private CategorieRepository categorieRepository ;
	@Autowired
	private VersionRepository versionRepository ;
	@Autowired
	private DocumentRepository documentRepository ; 
	@Autowired
	private EnvoieRepository envoieRepository ;
	
	@Override
	public int save(Documentwrapper documentwrapper , String to ) {
		Date date = new Date(System.currentTimeMillis()) ; 
		Document  document = documentwrapper.getDocument(); 
		Version version = documentwrapper.getVersion(); 
		Categorie categorie = documentwrapper.getCategorie(); 
		Employee employee = employeeRepository.findByName(( (User)session.getAttribute("user") ).getUsername()) ; 
		Employee dis_employee = employeeRepository.findByName(to) ; 
		
		document.setDate_creation(date);
		document.setDate_mise_ajour(date);
		document.setEmployee(employee);
		
		version.setDate_ajout(date);
		version.setDocument(document);
		
		categorie.setDocuments(documentwrapper.getDocument());
		
		documentRepository.save(document) ; 
		versionRepository.save(version) ; 
		categorieRepository.save(categorie) ; 
		Envoie_PK envoie_PK = new Envoie_PK(document , dis_employee) ;
		envoieRepository.save(new Envoie(envoie_PK , date , null , false)) ; 
		
		return dis_employee.getId() ; 
	}
	
	

}
