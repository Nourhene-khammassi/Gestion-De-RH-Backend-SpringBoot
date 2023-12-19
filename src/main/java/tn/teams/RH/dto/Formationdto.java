package tn.teams.RH.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.teams.RH.modeles.Formation;
import tn.teams.RH.modeles.SecteurFormation;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Formationdto {
	
	private Long idforma;
	@NotBlank(message = "priere de remplir le champs")
	private String nomformation;
	@NotBlank(message = "priere de remplir le champs")
	private Date debuformation;
	@NotBlank(message = "priere de remplir le champs")
	private Date finformation;
	@NotBlank(message = "priere de remplir le champs")
	@Enumerated(EnumType.STRING)
	private SecteurFormation secteurformation;
	@NotBlank(message = "priere de remplir le champs")
	private String lieuformation;
	private String instructeur;
	
	
	public static Formationdto FromEntity(Formation formation) {
		return Formationdto.builder()
				.idforma(formation.getIdforma())
				.nomformation(formation.getNomformation())
				.debuformation(formation.getDebuformation())
				.finformation(formation.getFinformation())
				.secteurformation(formation.getSecteurformation())
				.lieuformation(formation.getLieuformation())
				.instructeur(formation.getInstructeur())
				.build();
	}

	public static Formation toEntity(Formationdto dto) {
	    	return Formation.builder()
	    			.idforma(dto.getIdforma())
					.nomformation(dto.getNomformation())
					.debuformation(dto.getDebuformation())
					.finformation(dto.getFinformation())
					.secteurformation(dto.getSecteurformation())
					.lieuformation(dto.getLieuformation())
					.instructeur(dto.getInstructeur())
	    			.build();	
}

}
