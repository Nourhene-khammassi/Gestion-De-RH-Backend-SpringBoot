package tn.teams.RH.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tn.teams.RH.dto.Congedto;
import tn.teams.RH.services.CongeService;

@RestController
@RequestMapping("api/v1/conge")
@RequiredArgsConstructor
public class CongeController {
	private final CongeService congeService;
@PostMapping("/save/{id}")
	public Congedto save(@RequestBody Congedto dto, @PathVariable Long id) {
		return congeService.save(dto, id);
	}
@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		congeService.delete(id);
	}
@GetMapping("/finedbyid/{id}")
	public Congedto findById(@PathVariable Long id) {
		return congeService.findById(id);
	}
@GetMapping("/finedbyidemployee/{id}")
public List<Congedto> findByIdemployee(@PathVariable Long id) {
	return congeService.Congeemployee(id);
}


@GetMapping("/findall")
	public List<Congedto> findAllDepartement() {
		return congeService.findAllDepartement();
	}
	
@GetMapping("/save/{id}/{isva}")
public Congedto validationcong(@PathVariable Long id,@PathVariable Boolean isva) {
	return congeService.validationcong(id,isva);

}

@PostMapping("/update")
public Congedto save(@RequestBody Congedto dto) {
	return congeService.updatecong(dto);
}
}
