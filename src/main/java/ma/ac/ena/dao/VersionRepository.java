package ma.ac.ena.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ac.ena.entities.Version;

public interface VersionRepository extends JpaRepository<Version, Integer>{

}
