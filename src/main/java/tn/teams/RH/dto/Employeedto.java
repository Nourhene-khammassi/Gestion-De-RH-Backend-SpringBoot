package tn.teams.RH.dto;
import java.util.Date;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import tn.teams.RH.modeles.Employee;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Employeedto extends RegistrationRequest {
	@NotBlank(message = "priere de remplir le champs")
	private String matricule;
	@NotBlank(message = "priere de remplir le champs")
	private Date datenaissance;
	@NotBlank(message = "priere de remplir le champs")
	private Date dateembauche;
	@NotBlank(message = "priere de remplir le champs")
	private String sexeempl;
	@NotBlank(message = "priere de remplir le champs")
	private String gradeempl;
	@NotBlank(message = "priere de remplir le champs")
	private Float salaire;
	@NotBlank(message = "priere de remplir le champs")
	private String image;
private Departementdto departementdto;
public static Employeedto FromEntity(Employee empl) {
		return Employeedto.builder()
				.id(empl.getIduser())
				.matricule(empl.getMatricule())
				.password(empl.getPassword())
				.email(empl.getEmail())
				.fullname(empl.getFullname())
				.datenaissance(empl.getDatenaissance())
				.dateembauche(empl.getDateembauche())
				.sexeempl(empl.getSexeempl())
				.gradeempl(empl.getGradeempl())
				.salaire(empl.getSalaire())
				.departementdto(Departementdto.FromEntity(empl.getDepartement()))
				.image(empl.getImage())
				.build();
	}

	public static Employee toEntity(Employeedto dto) {
	    	return Employee.builder()
	    			.iduser(dto.getId())
	    			.matricule(dto.getMatricule())
	    			.datenaissance(dto.getDatenaissance())
	    			.password(dto.getPassword())
					.email(dto.getEmail())
					.fullname(dto.getFullname())
					.dateembauche(dto.getDateembauche())
					.sexeempl(dto.getSexeempl())
					.gradeempl(dto.getGradeempl())
					.salaire(dto.getSalaire())
					.departement(Departementdto.toEntity(dto.getDepartementdto()))
					.image(dto.getImage())
	    			.build();	
}
	
	
}
