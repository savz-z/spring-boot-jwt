package com.boot.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "actor")
public class Actor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9219179473712006839L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	@Column(name = "actor_name")
	private String actorname;
	
	@Column(name = "birth_date")
	private Date birthdate;
	
	@Column(name = "actor_desc1")
	private String actordesc1;
	
	@Column(name = "actor_desc2")
	private String actordesc2;
	
	@Column(name = "actor_desc3")
	private String actordesc3;
	
	@Column(name = "actor_desc4")
	private String actordesc4;
	
	@Column(name = "actor_desc5")
	private String actordesc5;
	
	@Column(name = "actor_path")
	private String actorpath;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActorname() {
		return actorname;
	}

	public void setActorname(String actorname) {
		this.actorname = actorname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getActordesc1() {
		return actordesc1;
	}

	public void setActordesc1(String actordesc1) {
		this.actordesc1 = actordesc1;
	}

	public String getActordesc2() {
		return actordesc2;
	}

	public void setActordesc2(String actordesc2) {
		this.actordesc2 = actordesc2;
	}

	public String getActordesc3() {
		return actordesc3;
	}

	public void setActordesc3(String actordesc3) {
		this.actordesc3 = actordesc3;
	}

	public String getActordesc4() {
		return actordesc4;
	}

	public void setActordesc4(String actordesc4) {
		this.actordesc4 = actordesc4;
	}

	public String getActordesc5() {
		return actordesc5;
	}

	public void setActordesc5(String actordesc5) {
		this.actordesc5 = actordesc5;
	}

	public String getActorpath() {
		return actorpath;
	}

	public void setActorpath(String actorpath) {
		this.actorpath = actorpath;
	}

	
}
