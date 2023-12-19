package tn.teams.RH.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import tn.teams.RH.modeles.Formation;

public interface FormationRepository extends JpaRepository<Formation, Long> {
	
	
	@Query("select t from Formation t left join fetch t.employees p where p.id like :userid")
	List<Formation> getFormationByIdemployee(@Param("userid") Long userids);
	
	
	
	/*@Query("select e from Formation e where e.employee.iduser like :im")
	public List<Formation> getFormationByIdemployee(@Param("im") Long name);*/
	
	/*@Query("select t from Formation t join User u where u.username = :username")
	List<Test> findAllByUsername(@Param("username")String username);*/
	
	/* @Query(value = "select  f from Formation f where em.iduser like :im" +
		        "inner join Employee em " +
		            "on f.idforma = em.iduser " +
		        "group by f.idforma, em.iduser " +
		        "order by em.iduser desc", nativeQuery = true)
		    List<Formation> getFormationByIdemployee(@Param("im") Long name);*/
}
