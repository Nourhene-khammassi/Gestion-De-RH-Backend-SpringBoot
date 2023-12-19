package tn.teams.RH.services;

import java.util.List;

import tn.teams.RH.dto.Departementdto;

public interface DepartenetService {
	Departementdto save(Departementdto dto);

	void delete(Integer id);

	Departementdto findById(Integer id);

	List<Departementdto> findAllDepartement();
}
