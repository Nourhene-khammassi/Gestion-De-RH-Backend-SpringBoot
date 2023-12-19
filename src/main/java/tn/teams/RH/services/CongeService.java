package tn.teams.RH.services;

import java.util.List;

import tn.teams.RH.dto.Congedto;

public interface CongeService {
	Congedto save(Congedto dto ,Long idempl);
	Congedto updatecong(Congedto dto );
	void delete(Long id);

	Congedto findById(Long id);
	Congedto validationcong(Long id,Boolean isva);

	List<Congedto> findAllDepartement();
	List<Congedto> Congeinvalide(Boolean invalide);
	List<Congedto> Congevalide(Boolean valide);
	List<Congedto> Congeemployee(Long iduser);
}
