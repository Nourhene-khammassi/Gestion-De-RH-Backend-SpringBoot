package tn.teams.RH.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tn.teams.RH.dto.Departementdto;
import tn.teams.RH.modeles.Departement;
import tn.teams.RH.repository.DepartementRepository;
import tn.teams.RH.validations.ObjectsValidator;


@Service
@RequiredArgsConstructor
public class DepatemetServiceimpl implements DepartenetService{
private final DepartementRepository departementRepository;
private final ObjectsValidator<Departementdto> x;
	@Override
	public Departementdto save(Departementdto dto) {
		x.validate(dto);
		Departement dept= Departementdto.toEntity(dto);
		Departement deptsaved= departementRepository.save(dept);
		Departementdto deptsaveddto=Departementdto.FromEntity(deptsaved);
		return deptsaveddto;
	}

	@Override
	public void delete(Integer id) {
		
		departementRepository.deleteById(id);
	}

	@Override
	public Departementdto findById(Integer id) {
		Departement dpt = departementRepository.findById(id).get();
		Departementdto dptdto=Departementdto.FromEntity(dpt);
		return dptdto;
	}

	@Override
	public List<Departementdto> findAllDepartement() {
		
		return departementRepository.findAll()
                .stream() // parcour la liste 
                .map(Departementdto :: FromEntity) // convertion liste 
                .collect(Collectors.toList());
		/*List<Departement> dpts=departementRepository.findAll();
		List<Departementdto> dptsdto=dpts.stream()
				.map(dpt->Departementdto.FromEntity(dpt))
				.collect(Collectors().toList());
		return dptsdto;*/
	}

}
