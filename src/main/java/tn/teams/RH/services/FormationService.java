package tn.teams.RH.services;

import java.util.List;

import tn.teams.RH.dto.Congedto;
import tn.teams.RH.dto.Formationdto;
import tn.teams.RH.dto.Formationsavemanydto;



public interface FormationService {
	Formationdto save(Formationsavemanydto dto);

	void delete(Long id);

	Formationdto findById(Long id);

	List<Formationdto> findAllformation();
	List<Formationdto> formationemployee(Long iduser);
}

