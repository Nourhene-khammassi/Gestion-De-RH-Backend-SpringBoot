package tn.teams.RH.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tn.teams.RH.dto.Consultationempldto;
import tn.teams.RH.dto.Employeedto;
import tn.teams.RH.modeles.Employee;
import tn.teams.RH.repository.EmployeeRepository;

@Service
@RequiredArgsConstructor
public class EmployeeServiceimpl implements EmployeeService {
	private final EmployeeRepository employeeRepository;

	@Override
	public void delete(Long id) {
		employeeRepository.deleteById(id);

	}
	
	@Override
	public Employeedto findById(Long id) {
		return employeeRepository.findById(id).map(Employeedto::FromEntity)
				.orElseThrow(() -> new EntityNotFoundException("No Employee was found with the provided ID"));

	}
	//pour admin
	@Override
	public Consultationempldto findByIdadmin(Long id) {
		return employeeRepository.findById(id).map(Consultationempldto::FromEntity)
				.orElseThrow(() -> new EntityNotFoundException("No Employee was found with the provided ID"));

	}
	//pour admin
	@Override
	public List<Consultationempldto> findAllEmployee() {
		List<Employee> empls = employeeRepository.findAll();
		List<Consultationempldto> empdto = empls.stream().map(emp -> Consultationempldto.FromEntity(emp)).collect(Collectors.toList());
		return empdto;
	}
	//recherche par fullname
	@Override
	public List<Consultationempldto> findEmployeebyname(String fullname) {
		// TODO Auto-generated method stub
		List<Employee> empls = employeeRepository.findALLempl(fullname);
		List<Consultationempldto> empdto = empls.stream().map(emp -> Consultationempldto.FromEntity(emp)).collect(Collectors.toList());
		return empdto;
	}
//recherche par matricule
	@Override
	public Consultationempldto findBymatricule(String matricule) {
		return employeeRepository.findByMatricule(matricule).map(Consultationempldto::FromEntity)
				.orElseThrow(() -> new EntityNotFoundException("No Employee was found with the provided matricule"));
	}

}
