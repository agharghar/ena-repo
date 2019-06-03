package ma.ac.ena.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ma.ac.ena.dao.EmployeeRepository;
import ma.ac.ena.entities.Employee;
import ma.ac.ena.entities.User;
import ma.ac.ena.services.EmployeeService;
import ma.ac.ena.services.UserService;
import ma.ac.ena.wrapper.Documentwrapper;

@Controller
public class UserController {
	
	@Autowired
	private EmployeeService employeeService ;
	@Autowired
	private HttpSession session ; 

	
	
	@GetMapping(path="/simple/envoie")
	public String employeeToEmployee(ModelMap modelMap , HttpSession session  ) {
		String username = ( (User ) session.getAttribute("user") ) .getUsername() ; 
		List<Employee> employees = employeeService.getAllUsersExeptMe(username) ; 

		modelMap.addAttribute("allEmployees", employees) ; 
		modelMap.addAttribute("documentWrapper" , new Documentwrapper()) ; 

		return "envoieForm" ; 
		
	}
	
	
	@GetMapping(path="/groupe/envoie")
	public String employeeToGroupe(ModelMap modelMap , HttpSession session  ) {
		String username = ( (User ) session.getAttribute("user") ) .getUsername() ; 
		List<Employee> employees = employeeService.getAllUsersExeptMe(username) ; 
		
		modelMap.addAttribute("allEmployees", employees.toArray()) ; 
		modelMap.addAttribute("documentWrapper" , new Documentwrapper()) ; 

		return "envoieGroupe" ; 
		
	}
	

	
	
}
