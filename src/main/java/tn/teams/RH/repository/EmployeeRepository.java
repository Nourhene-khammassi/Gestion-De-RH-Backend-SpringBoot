package tn.teams.RH.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.teams.RH.modeles.Employee;
import tn.teams.RH.modeles.User;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	Optional<Employee> findByMatricule(String matricule);
	Boolean existsByEmail(String email);
	@Query("select a from Employee a where a.fullname  LIKE %?1%")                                        
	   public  List<Employee> findALLempl(String keyword);
}
