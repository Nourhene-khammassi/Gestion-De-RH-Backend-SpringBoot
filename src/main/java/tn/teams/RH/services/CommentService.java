package tn.teams.RH.services;

import java.util.List;

import tn.teams.RH.dto.Commentdto;
import tn.teams.RH.dto.Congedto;



public interface CommentService {
	Commentdto save(Commentdto dto,Long idpst,Long idempl);
	void delete(Long id);
	Commentdto findById(Long id);
	List<Commentdto> findAllcommentair();
	List<Commentdto> commentairemployee(Long idpost);
}
