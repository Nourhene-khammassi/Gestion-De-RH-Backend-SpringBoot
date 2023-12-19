package tn.teams.RH.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.teams.RH.modeles.Conge;
import tn.teams.RH.modeles.TypeConge;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Congedto {
	private Long idconge;
	
	//@JsonFormat(pattern = "yyyy-MM-dd")
	private Date debuconge;
	//@JsonFormat(pattern = "yyyy-MM-dd")
	private Date finconge;
	
	private Integer nbrjours;
	@NotBlank(message = "priere de remplir le champs")
	private TypeConge typeconge;
	@NotBlank(message = "priere de remplir le champs")
	private Boolean isvalide;
	@NotBlank(message = "priere de remplir le champs")
	private String cause;
	
	private Employeedto employeedto;
	private String remplacent;

	public static Congedto FromEntity(Conge cong) {
		return Congedto.builder().idconge(cong.getIdconge()).debuconge(cong.getDebuconge()).finconge(cong.getFinconge())
				.nbrjours(cong.getNbrjours()).typeconge(cong.getTypeconge()).isvalide(cong.getIsvalide())
				.cause(cong.getCause())
				//.employeedto(Employeedto.FromEntity(cong.getEmployee()))
				.remplacent(cong.getRemplacent()).build();
	}

	public static Conge toEntity(Congedto dto) {
		return Conge.builder().idconge(dto.getIdconge()).debuconge(dto.getDebuconge()).finconge(dto.getFinconge())
				.typeconge(dto.getTypeconge())
				.nbrjours(dto.getNbrjours())
				.isvalide(dto.getIsvalide()).cause(dto.getCause())
				//.employee(Employeedto.toEntity(dto.getEmployeedto()))
				.remplacent(dto.getRemplacent()).build();
	}

}
