package ma.ac.ena.services;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.ac.ena.dao.DocumentRepository;
import ma.ac.ena.dao.EnvoieRepository;
import ma.ac.ena.entities.Document;
import ma.ac.ena.entities.Envoie;

@Service
public class EnvoieServiceImpl implements EnvoieService{

	@Autowired
	private DocumentRepository documentRepository ; 
	@Autowired
	private EnvoieRepository envoieRepository ; 
	
	@Override
	public Envoie isAuth(URI uri, int id) {
		
		Document document = documentRepository.findBychemin(uri.getPath().substring(1, uri.getPath().length())) ; 
		
		System.out.println(uri.getPath().substring(1, uri.getPath().length()));
		if(document == null )
			return null;
		Envoie envoie = envoieRepository.findByIdAndRef(id, document.getRef()) ; 
		if(envoie == null)
			return null ; 
		
		return envoie ; 
	}

	@Override
	public void setLu(Envoie envoie) {
		envoie.setLu(true);
		envoieRepository.save(envoie) ; 
		
	}




	
	
	
	
	

}
