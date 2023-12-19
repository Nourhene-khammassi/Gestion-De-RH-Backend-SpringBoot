package tn.teams.RH.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tn.teams.RH.dto.Congedto;
import tn.teams.RH.dto.Formationdto;
import tn.teams.RH.dto.Formationsavemanydto;
import tn.teams.RH.modeles.Conge;
import tn.teams.RH.services.FormationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/formation")
public class FormationController {
	private final FormationService formationService;
	@PostMapping("/save")
	public Formationdto save(@RequestBody Formationsavemanydto dto) {
		return formationService.save(dto);
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		formationService.delete(id);
	}
	@GetMapping("/findbyid/{id}")
	public Formationdto findById(@PathVariable Long id) {
		return formationService.findById(id);
	}
	@GetMapping("/findbyALL")
	public List<Formationdto> findAllformation() {
		return formationService.findAllformation();
	}
	
	@GetMapping("/finedbyidemployee/{id}")
	public List<Formationdto> findByIdemployee(@PathVariable Long id) {
		return formationService.formationemployee(id);
	}

}
