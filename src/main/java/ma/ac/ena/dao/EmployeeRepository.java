package ma.ac.ena.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.ac.ena.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee , Integer>{

	@Query("select e from Employee e INNER JOIN User u ON u.id = e.user.id AND u.username = :name")
	Employee findByName(@Param("name") String name);

}
