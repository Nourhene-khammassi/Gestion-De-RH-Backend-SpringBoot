package tn.teams.RH.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.teams.RH.modeles.Conge;
import tn.teams.RH.modeles.User;


public interface CongeRepository extends JpaRepository<Conge, Long>{
	@Query("select e from Conge e where e.employee.iduser like :im")
	public List<Conge> getCongeByIdemployee(@Param("im") Long name);
	
	
	
	List<Conge> findByIsvalide(Boolean isvalid);
}
