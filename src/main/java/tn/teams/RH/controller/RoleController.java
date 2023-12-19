package tn.teams.RH.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.teams.RH.modeles.Role;
import tn.teams.RH.repository.RoleRepository;

@RestController
@RequestMapping("/role")
public class RoleController {
  @Autowired
 private  RoleRepository roleRepository;
  @GetMapping("/getallroles")
  public List<Role> getallrole(){
	
	  return roleRepository.findAll() ;
	  
  }
  @PostMapping("/saveroles")
  public Role saverole(@RequestBody Role role){
	
	  return roleRepository.save(role) ;
  }
}
