package tn.teams.RH.modeles;


import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Employee extends User{
private String matricule;
private Date datenaissance;
private Date dateembauche;
private String sexeempl;
private String gradeempl;
private Float salaire;
private String image;
@ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
Departement departement;
@OneToMany
Set<Conge> conges;
@OneToMany
Set<Noteservice> postes;
@OneToMany
Set<Comment> comments;
//@JsonIgnore
//@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
@ManyToMany(mappedBy = "employees" , fetch = FetchType.LAZY )
Set<Formation> formations;



}
