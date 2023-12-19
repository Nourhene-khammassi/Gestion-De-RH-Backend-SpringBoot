package tn.teams.RH.services;

import tn.teams.RH.dto.AuthenticationRequest;
import tn.teams.RH.dto.AuthenticationResponse;
import tn.teams.RH.dto.RegistrationRequest;

public interface UserService  {

  
  AuthenticationResponse register(RegistrationRequest request);

  AuthenticationResponse authenticate(AuthenticationRequest request);
  
  void createadmine();
 

}
