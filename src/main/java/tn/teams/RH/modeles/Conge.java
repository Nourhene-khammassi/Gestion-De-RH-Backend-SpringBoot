package tn.teams.RH.modeles;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Conge {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idconge;
	
	
	////
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date debuconge;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date finconge;
	///
	
	private Integer nbrjours;
	@Enumerated(EnumType.STRING)
	private TypeConge typeconge;
	private Boolean isvalide;
	private String cause;
	@ManyToOne(fetch = FetchType.LAZY)
	private Employee employee;
	private String remplacent;

}
