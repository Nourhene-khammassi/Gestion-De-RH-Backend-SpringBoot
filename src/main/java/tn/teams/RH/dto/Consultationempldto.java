package tn.teams.RH.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.teams.RH.modeles.Employee;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Consultationempldto {
	private Long id;
	private String matricule;
	private String email;
	private Date datenaissance;
	private String fullname;
	private Date dateembauche;
	private String sexeempl;
	private String gradeempl;
	private Float salaire;
	
private Departementdto departementdto;
public static Consultationempldto FromEntity(Employee empl) {
		return Consultationempldto.builder()
				.id(empl.getIduser())
				.matricule(empl.getMatricule())
				.email(empl.getEmail())
				.fullname(empl.getFullname())
				.datenaissance(empl.getDatenaissance())
				.dateembauche(empl.getDateembauche())
				.sexeempl(empl.getSexeempl())
				.gradeempl(empl.getGradeempl())
				.salaire(empl.getSalaire())
				.departementdto(Departementdto.FromEntity(empl.getDepartement()))
				
				.build();
	}

	public static Employee toEntity(Employeedto dto) {
	    	return Employee.builder()
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
			
	    			.build();	
}
	
	
}

