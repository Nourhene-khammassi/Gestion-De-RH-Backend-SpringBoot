package tn.teams.RH.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.teams.RH.modeles.Employee;
import tn.teams.RH.modeles.Noteservice;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Postdto {
	private Long id;
	@NotBlank(message = "priere de remplir le nom de poste")
	private String nomPost;
	@NotBlank(message = "priere de remplir la description")
	private String description;
	@NotBlank(message = "priere de remplir le date")
	private Date dateAjout;
	//private Employeedto employeedto;
	public static Postdto FromEntity(Noteservice post) {
		return Postdto.builder()
				.id(post.getId())
				.nomPost(post.getNomPost())
				.description(post.getDescription())
				.dateAjout(post.getDateAjout())
				//.employeedto(Employeedto.FromEntity(post.getEmployee()))
				.build();
	}

	public static Noteservice toEntity(Postdto dto) {
	    	return Noteservice.builder()
	    			.nomPost(dto.getNomPost())
					.description(dto.getDescription())
					.dateAjout(dto.getDateAjout())
					//.employee(Employeedto.toEntity(dto.getEmployeedto()))
	    			.build();	
}
}