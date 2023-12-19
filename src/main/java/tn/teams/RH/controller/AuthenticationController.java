package tn.teams.RH.controller;


import lombok.RequiredArgsConstructor;
import tn.teams.RH.dto.AuthenticationRequest;
import tn.teams.RH.dto.AuthenticationResponse;
import tn.teams.RH.dto.Employeedto;
import tn.teams.RH.repository.EmployeeRepository;
import tn.teams.RH.services.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserService service;
    private final EmployeeRepository emprepository; 

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody Employeedto request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    /*@GetMapping("/listerUser")
    public List<User> getUsers(){
        return userRepository.findAll();
    }*/
}