package tn.teams.RH.modeles;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.teams.RH.dto.Postdto;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "post")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Noteservice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "refnote")
	private String nomPost;
	@Column(name = "description")
	private String description;
	@Temporal (TemporalType.DATE)
    private Date dateAjout = new Date();
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	private Employee employee;
	@JsonIgnore
	@OneToMany(mappedBy="post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private List<Comment>  comments;
	
	
}
