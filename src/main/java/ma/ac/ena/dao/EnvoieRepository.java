package ma.ac.ena.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.ac.ena.entities.Document;
import ma.ac.ena.entities.Employee;
import ma.ac.ena.entities.Envoie;
import ma.ac.ena.entities.Envoie_PK;

public interface EnvoieRepository extends JpaRepository<Envoie, Envoie_PK>{
	
	@Query("select d from Document d INNER JOIN Envoie e  ON d.ref = e.envoie_PK.document.ref AND e.envoie_PK.employee.id = :id  AND e.lu = false")
	public Set<Document> findDocumentNonLu(int id);
	@Query("select e from Envoie e where e.envoie_PK.document.ref = :ref AND e.envoie_PK.employee.id = :id")
	public Envoie findByIdAndRef(int id , String ref ) ;

}
