package tn.teams.RH.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.teams.RH.modeles.Comment;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Commentdto
{

	private Long id ;
	@NotBlank(message = "priere de remplir le champs")
    private Date dateAjout;
	@NotBlank(message = "priere de remplir le champs")
	private String comments;
	

public static Commentdto FromEntity(Comment com) {
	return Commentdto.builder()
			.id(com.getId())
			.dateAjout(com.getDateAjout())
			.comments(com.getComments())
			.build();
}
public static Comment toEntity (Commentdto dto ) {
	return Comment.builder()
			.id(dto.getId())
			.dateAjout(dto.getDateAjout())
			.comments(dto.getComments())
			.build();
			
}
}


