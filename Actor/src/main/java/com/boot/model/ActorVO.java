package com.boot.model;

import java.util.Date;
import java.util.List;

public class ActorVO {
	
	private Long actorid;
	
	private String actorname;
	
	private Date birthdate;
	
	private String actordesc1;
	
	private String actordesc2;
	
	private String actordesc3;
	
	private String actordesc4;
	
	private String actordesc5;
	
	private String actorpath;
	
	private List<MovieVO> movies;

	
	public ActorVO() {
		
	}
	
	public ActorVO(Long actorid, String actorname, Date birthdate, String actordesc1, String actordesc2, String actordesc3, String actordesc4, String actordesc5, String actorpath) {
		this.actorid = actorid;
		this.actorname = actorname;
		this.birthdate = birthdate;
		this.actordesc1 = actordesc1;
		this.actordesc2 = actordesc2;
		this.actordesc3 = actordesc3;
		this.actordesc4 = actordesc4;
		this.actordesc5 = actordesc5;
		this.actorpath = actorpath;
	}
	
	public Long getActorid() {
		return actorid;
	}

	public void setActorid(Long actorid) {
		this.actorid = actorid;
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

	public List<MovieVO> getMovies() {
		return movies;
	}

	public void setMovies(List<MovieVO> movies) {
		this.movies = movies;
	}
	
	
	
	

}
