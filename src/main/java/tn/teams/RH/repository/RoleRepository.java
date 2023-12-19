package tn.teams.RH.repository;

import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;

import tn.teams.RH.modeles.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	 Optional<Role> findByName(String role);
	 Boolean existsByName(String name);
}
