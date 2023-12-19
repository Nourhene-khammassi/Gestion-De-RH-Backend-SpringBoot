package tn.teams.RH.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.teams.RH.modeles.Departement;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Departementdto {
	private Integer iddept;
	@NotBlank(message = "priere de remplir le champs")
	private String namedpt;
	
	public static Departementdto FromEntity(Departement dep) {
		return Departementdto.builder()
				.iddept(dep.getIddept())
				.namedpt(dep.getNamedpt())
				.build();
	
	}
	public static Departement toEntity(Departementdto dto) {
    	return Departement.builder()
    			//.iddept(dto.getIddept())
    			.namedpt(dto.getNamedpt())
    			.build();	
	
	}}


