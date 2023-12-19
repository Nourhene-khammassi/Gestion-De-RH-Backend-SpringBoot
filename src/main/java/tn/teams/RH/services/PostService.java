package tn.teams.RH.services;

import java.util.List;

import tn.teams.RH.dto.Postdto;



public interface PostService {
	Postdto save(Postdto dto,Long id);

	void delete(Long id);

	Postdto findById(Long id);

	List<Postdto> findAllposte();
}

