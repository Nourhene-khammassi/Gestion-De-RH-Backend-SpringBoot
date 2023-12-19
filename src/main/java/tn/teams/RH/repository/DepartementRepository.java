package tn.teams.RH.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.teams.RH.modeles.Departement;
import tn.teams.RH.modeles.User;

public interface DepartementRepository extends JpaRepository<Departement, Integer>{
	Boolean existsByNamedpt(String name);
	Departement findByNamedpt(String name);
}
