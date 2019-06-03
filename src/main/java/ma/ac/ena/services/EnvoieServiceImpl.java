package ma.ac.ena.services;

import java.net.URI;
import java.util.Date;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.ac.ena.dao.DocumentRepository;
import ma.ac.ena.dao.EnvoieRepository;
import ma.ac.ena.entities.Document;
import ma.ac.ena.entities.Employee;
import ma.ac.ena.entities.Envoie;

@Service
public class EnvoieServiceImpl implements EnvoieService{

	@Autowired
	private DocumentRepository documentRepository ; 
	@Autowired
	private EnvoieRepository envoieRepository ; 
	@Autowired
	private HttpSession session ;
	
	@Override
	public Envoie isAuth(String fileName, int id) {
		
		Document document = documentRepository.findBynomFichier(fileName) ; 
		
		if(document == null )
			return null;
		Envoie envoie = envoieRepository.findByIdAndId(id, document.getId()) ; 
		if(envoie == null)
			return null ; 
		
		return envoie ; 
	}

	@Override
	public void setLu(Envoie envoie) {
		envoie.setLu(true);
		Document document = envoie.getEnvoie_PK().getDocument() ; 
		Set<Document> documentsNonLu = (Set<Document>) session.getAttribute("documentNonLu") ; 
		
		documentsNonLu.remove(document) ;
		session.setAttribute("documentNonLu", documentsNonLu);
		

		
		if ( envoie.getDate_reception() == null) {
			Date date = new Date(System.currentTimeMillis()) ; 
			envoie.setDate_reception(date);
		}
		envoieRepository.save(envoie) ; 
		
	}




	
	
	
	
	

}
