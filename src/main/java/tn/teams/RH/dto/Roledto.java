package tn.teams.RH.dto;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.BeanUtils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.teams.RH.modeles.Role;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Roledto {
	private Integer idRole;
	@NotBlank(message = "priere de remplir le nom de role")
	private String name;

	// les methode de mappage
	public static Roledto fromentitie(Role role) {
		Roledto roleondto = new Roledto();
		BeanUtils.copyProperties(role, roleondto);
		return roleondto;
	}

	public static Role toentitie(Roledto dto) {
		Role role = new Role();
		BeanUtils.copyProperties(dto, role);
		return role;

	}

}
