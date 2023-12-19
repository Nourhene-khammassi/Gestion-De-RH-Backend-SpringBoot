package tn.teams.RH.services;

import java.util.List;

import tn.teams.RH.dto.Consultationempldto;
import tn.teams.RH.dto.Employeedto;

public interface EmployeeService {
//admin
	void delete(Long id);
	Employeedto findById(Long id);
	Consultationempldto findByIdadmin(Long id);
	List<Consultationempldto> findAllEmployee();
	List<Consultationempldto> findEmployeebyname(String fullname);
	Consultationempldto findBymatricule(String matricule);

}
