package tn.teams.RH.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tn.teams.RH.dto.Commentdto;
import tn.teams.RH.dto.Congedto;
import tn.teams.RH.dto.Postdto;
import tn.teams.RH.modeles.Comment;
import tn.teams.RH.modeles.Employee;
import tn.teams.RH.modeles.Noteservice;
import tn.teams.RH.repository.ComentRepository;
import tn.teams.RH.repository.EmployeeRepository;
import tn.teams.RH.repository.PostRepository;
import tn.teams.RH.validations.ObjectsValidator;
@Service
@RequiredArgsConstructor
public class CommentServiceimpl implements CommentService {
	private final PostRepository postRepository;
	private final EmployeeRepository employeeRepository ;
	private final ComentRepository comentRepository ;
	@Override
	public Commentdto save(Commentdto dto,Long idpst,Long idempl) {
		Employee empl=employeeRepository.findById(idempl).get();
		Noteservice post=postRepository.findById(idpst).get();
		Comment comm= Commentdto.toEntity(dto);
		comm.setEmployee(empl);
		comm.setPost(post);
		Comment commsaved=comentRepository.save(comm);
		Commentdto commdto= Commentdto.FromEntity(commsaved) ;
		
		return commdto;
	}

	@Override
	public void delete(Long id) {
		comentRepository.deleteById(id);
		
	}

	@Override
	public Commentdto findById(Long id) {
		Comment comm = comentRepository.findById(id).get();
		Commentdto commentdto=Commentdto.FromEntity(comm);
		return commentdto;
	}

	@Override
	public List<Commentdto> findAllcommentair() {
		return comentRepository.findAll()
                .stream() // parcour la liste 
                .map(Commentdto :: FromEntity) // convertion liste 
                .collect(Collectors.toList());
	}

	@Override
	public List<Commentdto> commentairemployee(Long idpost) {

		return comentRepository.getCongeByIdcommentair(idpost).stream() // parcour la liste
				.map(Commentdto::FromEntity) // convertion liste
				.collect(Collectors.toList());
	}

}
