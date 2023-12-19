package tn.teams.RH.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.teams.RH.modeles.Comment;


public interface ComentRepository extends JpaRepository<Comment, Long> {
	@Query("select e from Comment e where e.post.id like :im")
	public List<Comment> getCongeByIdcommentair(@Param("im") Long name);
	
}
