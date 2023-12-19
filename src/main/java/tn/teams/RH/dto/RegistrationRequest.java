package tn.teams.RH.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class RegistrationRequest {
	private Long id;
	@NotBlank(message = "priere de remplir lastname")
	private String fullname;
	@Email(message = "priere de respecter le format email")
	private String email;
	@NotBlank(message = "priere de remplir mot de passe")
	private String password;
	@NotBlank(message = "priere de remplir role")
	private Set<String> role;

}