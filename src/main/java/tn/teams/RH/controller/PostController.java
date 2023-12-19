package tn.teams.RH.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tn.teams.RH.dto.Postdto;
import tn.teams.RH.services.PostService;


@RestController
@RequestMapping("api/v1/post")
@RequiredArgsConstructor
public class PostController {
	private final PostService postService;
@PostMapping("/save/{id}") 
	public Postdto save(@RequestBody Postdto dto,@PathVariable Long id) {
		return postService.save(dto,id);
	}
@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		postService.delete(id);
	}
@GetMapping("/findbyid/{id}")
	public Postdto findById(@PathVariable Long id) {
		return postService.findById(id);
	}
@GetMapping("/findbyALL")
	public List<Postdto> findAllposte() {
		return postService.findAllposte();
	}
	

}
