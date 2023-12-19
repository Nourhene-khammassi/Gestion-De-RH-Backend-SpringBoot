package tn.teams.RH.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.teams.RH.modeles.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByEmail(String email);
	
}
