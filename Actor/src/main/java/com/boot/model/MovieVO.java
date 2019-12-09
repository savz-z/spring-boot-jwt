package com.boot.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


public class MovieVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 376653493478118001L;

	private Long movieid;
	
	private String moviename;
	
	private Integer releaseyear;
	
	private Date releasedate;
	
	private String director;
	
	private String synopsis;
	
	private String moviepath;
	
	private String trailerurl;
	
	private List<ActorVO> actors;
	
	public MovieVO() {
		
	}
	
	public MovieVO(Long id, String moviename, Date releasedate, String director,String moviepath){
		this.movieid = id;
		this.moviename = moviename;
		this.releasedate = releasedate;
		this.director = director;
		this.moviepath = moviepath;
	}

	

	public Long getMovieid() {
		return movieid;
	}

	public void setMovieid(Long movieid) {
		this.movieid = movieid;
	}

	public String getMoviename() {
		return moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}

	public Integer getReleaseyear() {
		return releaseyear;
	}

	public void setReleaseyear(Integer releaseyear) {
		this.releaseyear = releaseyear;
	}

	public Date getReleasedate() {
		return releasedate;
	}

	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getMoviepath() {
		return moviepath;
	}

	public void setMoviepath(String moviepath) {
		this.moviepath = moviepath;
	}

	public String getTrailerurl() {
		return trailerurl;
	}

	public void setTrailerurl(String trailerurl) {
		this.trailerurl = trailerurl;
	}

	public List<ActorVO> getActors() {
		return actors;
	}

	public void setActors(List<ActorVO> actors) {
		this.actors = actors;
	}
}
