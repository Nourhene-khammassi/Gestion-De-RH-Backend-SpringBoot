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
import tn.teams.RH.dto.Commentdto;
import tn.teams.RH.dto.Congedto;
import tn.teams.RH.services.CommentService;
import tn.teams.RH.services.CongeService;

@RestController
@RequestMapping("api/v1/commentair")
@RequiredArgsConstructor
public class CommentController {
	private final CommentService commentService;
	@PostMapping("/save/{idpst}/{idempl}")
	public Commentdto save(@RequestBody Commentdto dto, @PathVariable Long idpst,@PathVariable Long idempl) {
		return commentService.save(dto, idpst, idempl);
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		commentService.delete(id);
	}
	@GetMapping("/finedbyid/{id}")
	public Commentdto findById(@PathVariable Long id) {
		return commentService.findById(id);
	}
	@GetMapping("/findall")
	public List<Commentdto> findAllcommentair() {
		return commentService.findAllcommentair();
	}
	
	@GetMapping("/finedbyidpost/{id}")
	public List<Commentdto> findByIdpostes(@PathVariable Long id) {
		return commentService.commentairemployee(id);
	}
}
