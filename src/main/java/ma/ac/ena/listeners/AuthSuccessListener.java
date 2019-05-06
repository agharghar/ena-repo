package ma.ac.ena.listeners;

import java.util.Set;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import ma.ac.ena.dao.EmployeeRepository;
import ma.ac.ena.dao.EnvoieRepository;
import ma.ac.ena.dao.UserRepository;
import ma.ac.ena.entities.Document;
import ma.ac.ena.entities.Employee;

@Component
public class AuthSuccessListener implements ApplicationListener<AuthenticationSuccessEvent>{
	
	@Autowired
	private UserRepository userRepository ;
	@Autowired
	private HttpSession session;
	@Autowired
	private EnvoieRepository envoieRepository ; 
	@Autowired
	private EmployeeRepository employeeRepository ;
	
	@Override
	public void onApplicationEvent(AuthenticationSuccessEvent event ) {
		String username = ((UserDetails) event.getAuthentication().getPrincipal()).getUsername() ; 
		Set<Document> documentsNonLu = envoieRepository.findDocumentNonLu( ((Employee) employeeRepository.findByName(username)).getId() ) ; 
		
		session.setAttribute("user", userRepository.findByUsername(username));
		session.setAttribute("documentNonLu", documentsNonLu);
		
		
	} 
	
	
	
	
	
}
