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
import tn.teams.RH.dto.Departementdto;
import tn.teams.RH.services.DepartenetService;

@RestController
@RequestMapping("api/v1/departement")
@RequiredArgsConstructor
public class DepartementController {
	private final DepartenetService departenetService;
@PostMapping("/save")
	public Departementdto save(@RequestBody Departementdto dto) {
		return departenetService.save(dto);
	}
@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable  Integer id) {
		departenetService.delete(id);
	}
@GetMapping("findbyid/{id}")
	public Departementdto findById(@PathVariable Integer id) {
		return departenetService.findById(id);
	}
@GetMapping("/findbyALL")
	public List<Departementdto> findAllDepartement() {
		return departenetService.findAllDepartement();
	}
	
	

}
