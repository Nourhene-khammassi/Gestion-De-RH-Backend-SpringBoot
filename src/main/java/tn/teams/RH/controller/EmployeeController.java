package tn.teams.RH.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tn.teams.RH.dto.Consultationempldto;
import tn.teams.RH.dto.Employeedto;
import tn.teams.RH.repository.EmployeeRepository;
import tn.teams.RH.services.EmployeeService;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {
	
	private final EmployeeService employeeService;
@DeleteMapping("/delete/{id}")  
	public void delete(@PathVariable Long id) {
		employeeService.delete(id);
	}
@GetMapping("/finedbyid/{id}")
	public Employeedto findById(@PathVariable Long id) {
		return employeeService.findById(id);
	}
@GetMapping("/finedbyidadmin/{id}")
public Consultationempldto findByIdadmine(@PathVariable Long id) {
	return employeeService.findByIdadmin(id);
}

@GetMapping("/listeall")
	public List<Consultationempldto> findAllEmployee() {
		return employeeService.findAllEmployee();
	}
@GetMapping("/finedbyfullname/{fullname}")
	public List<Consultationempldto> findEmployeebyname(@PathVariable String fullname) {
		return employeeService.findEmployeebyname(fullname);
	}
@GetMapping("/finedbymatricule/{matricule}")
	public Consultationempldto findBymatricule(@PathVariable String matricule) {
		return employeeService.findBymatricule(matricule);
	}
	
	
	

}
