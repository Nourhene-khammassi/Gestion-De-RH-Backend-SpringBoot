package tn.teams.RH.modeles;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
public class Formation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idforma;
	private String nomformation;
	private Date debuformation;
	private Date finformation;
	@Enumerated(EnumType.STRING)
	private SecteurFormation secteurformation;
	private String lieuformation;
	private String instructeur;
	@ManyToMany
	Set<Employee> employees;
	
	

}
