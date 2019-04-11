package ma.ac.ena.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ac.ena.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

	User findByUsernameAndPassword(String username, String password);

	User findByUsername(String username);
}

