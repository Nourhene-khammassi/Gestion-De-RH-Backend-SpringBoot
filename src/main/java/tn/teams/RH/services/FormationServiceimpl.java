package tn.teams.RH.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tn.teams.RH.dto.Congedto;
import tn.teams.RH.dto.Formationdto;
import tn.teams.RH.dto.Formationsavemanydto;
import tn.teams.RH.modeles.Employee;
import tn.teams.RH.modeles.Formation;
import tn.teams.RH.repository.EmployeeRepository;
import tn.teams.RH.repository.FormationRepository;
import tn.teams.RH.validations.ObjectsValidator;


@Service
@RequiredArgsConstructor
public class FormationServiceimpl implements FormationService {

	private final FormationRepository formationRepository;
	private final EmployeeRepository employeeRepository;
	private final ObjectsValidator<Formationdto> x;

	@Override
	public Formationdto save(Formationsavemanydto dto) {
		//x.validate(dto);
		Formation formtion=Formationsavemanydto.toEntity(dto);
		System.out.println(dto.getIdempls());
	Set<Long> strEmps= dto.getIdempls();
        Set<Employee> emps = new HashSet<>();
        strEmps.forEach(ids -> {
        	Employee enmp = employeeRepository.findById(ids)
                    .orElseThrow(() -> new RuntimeException("not found."));
        	emps.add(enmp);

            
    });
        formtion.setEmployees(emps);
		
		
		
		Formation formationsaved = formationRepository.save(formtion);
		return Formationdto.FromEntity(formationsaved);
	}

	@Override
	public void delete(Long id) {
		Formation formation= formationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + " not found"));
		formationRepository.deleteById(id);

	}

	@Override
	public Formationdto findById(Long id) {
		return formationRepository.findById(id).map(Formationdto::FromEntity)
				.orElseThrow(() -> new EntityNotFoundException("No conge was found with the provided ID"));
	}

	@Override
	public List<Formationdto> findAllformation() {
		// TODO Auto-generated method stub
		return formationRepository.findAll().stream() // parcour la liste
				.map(Formationdto::FromEntity) // convertion liste
				.collect(Collectors.toList());
	}
	@Override
	public List<Formationdto> formationemployee(Long iduser) {
	
		return formationRepository.getFormationByIdemployee(iduser).stream() // parcour la liste
				.map(Formationdto::FromEntity) // convertion liste
				.collect(Collectors.toList());
	}

}
