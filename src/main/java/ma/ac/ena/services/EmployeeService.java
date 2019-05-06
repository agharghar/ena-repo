package ma.ac.ena.services;

import java.util.List;

import org.springframework.security.core.AuthenticatedPrincipal;

import ma.ac.ena.entities.Employee;
import ma.ac.ena.entities.User;

public interface EmployeeService  {

	List<Employee> getAllUsersExeptMe(String username);

}
