package tn.teams.RH.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.PostRemove;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tn.teams.RH.dto.Departementdto;
import tn.teams.RH.dto.Postdto;
import tn.teams.RH.modeles.Departement;
import tn.teams.RH.modeles.Employee;
import tn.teams.RH.modeles.Noteservice;
import tn.teams.RH.repository.EmployeeRepository;
import tn.teams.RH.repository.PostRepository;
import tn.teams.RH.validations.ObjectsValidator;
@Service
@RequiredArgsConstructor
public class PostServiceimpl implements PostService{
private final PostRepository postRepository;
private final EmployeeRepository employeeRepository ;
private final ObjectsValidator<Postdto> x;
	@Override
	public Postdto save(Postdto dto,Long id) {
		//x.validate(dto);
		Employee empl=employeeRepository.findById(id).get();
		
		Noteservice post= Postdto.toEntity(dto);
		post.setEmployee(empl);
		Noteservice postsaved= postRepository.save(post);
		Postdto postsaveddto=Postdto.FromEntity(postsaved);
		return postsaveddto;
	}

	@Override
	public void delete(Long id) {
		postRepository.deleteById(id);
		
	}

	@Override
	public Postdto findById(Long id) {
		Noteservice post = postRepository.findById(id).get();
		Postdto postdto=Postdto.FromEntity(post);
		return postdto;
	}

	@Override
	public List<Postdto> findAllposte() {
		return postRepository.findAll()
                .stream() // parcour la liste 
                .map(Postdto :: FromEntity) // convertion liste 
                .collect(Collectors.toList());
	}

}
