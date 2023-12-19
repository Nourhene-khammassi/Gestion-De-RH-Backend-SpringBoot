package tn.teams.RH.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.teams.RH.modeles.Noteservice;

public interface PostRepository extends JpaRepository<Noteservice, Long>{

}
