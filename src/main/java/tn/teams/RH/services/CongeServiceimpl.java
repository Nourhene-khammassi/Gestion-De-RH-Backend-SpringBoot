package tn.teams.RH.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tn.teams.RH.dto.Congedto;
import tn.teams.RH.modeles.Conge;
import tn.teams.RH.modeles.Employee;
import tn.teams.RH.repository.CongeRepository;
import tn.teams.RH.repository.EmployeeRepository;
import tn.teams.RH.validations.ObjectsValidator;
@Service
@RequiredArgsConstructor
public class CongeServiceimpl implements CongeService {
	private final CongeRepository congeRepository;
	private final EmployeeRepository employeeRepository;
	private final ObjectsValidator<Congedto> x;

	@Override
	public Congedto save(Congedto dto, Long idempl) {
		//x.validate(dto);
		Employee empl = employeeRepository.findById(idempl).get();
		Conge conge = Congedto.toEntity(dto);
		conge.setEmployee(empl);
		Conge congesaved = congeRepository.save(conge);
		return Congedto.FromEntity(congesaved);
	}

	@Override
	public void delete(Long id) {
		Conge conge = congeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + " not found"));
		congeRepository.deleteById(id);

	}

	@Override
	public Congedto findById(Long id) {
		return congeRepository.findById(id).map(Congedto::FromEntity)
				.orElseThrow(() -> new EntityNotFoundException("No conge was found with the provided ID"));
	}

	@Override
	public List<Congedto> findAllDepartement() {
		// TODO Auto-generated method stub
		return congeRepository.findAll().stream() // parcour la liste
				.map(Congedto::FromEntity) // convertion liste
				.collect(Collectors.toList());
	}

	@Override
	public List<Congedto> Congeinvalide(Boolean invalide) {
		invalide=false;
		return congeRepository.findByIsvalide(invalide).stream() // parcour la liste
				.map(Congedto::FromEntity) // convertion liste
				.collect(Collectors.toList());
	}

	@Override
	public List<Congedto> Congevalide(Boolean valide) {
		valide=true;
		return congeRepository.findByIsvalide(valide).stream() // parcour la liste
				.map(Congedto::FromEntity) // convertion liste
				.collect(Collectors.toList());
	}

	@Override
	public List<Congedto> Congeemployee(Long iduser) {
	
		return congeRepository.getCongeByIdemployee(iduser).stream() // parcour la liste
				.map(Congedto::FromEntity) // convertion liste
				.collect(Collectors.toList());
	}

	@Override
	public Congedto validationcong(Long id,Boolean isva) {
		Conge conge = congeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + " not found"));
		conge.setIsvalide(isva);
		Conge congesaved = congeRepository.save(conge);
		return Congedto.FromEntity(congesaved);
	}

	@Override
	public Congedto updatecong(Congedto dto) {
	
		Conge conge = Congedto.toEntity(dto);
		Conge congesaved = congeRepository.save(conge);
		return Congedto.FromEntity(congesaved);
	}

}
