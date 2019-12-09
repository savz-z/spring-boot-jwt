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
@Table(name = "movie")
public class Movie implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9219179473712006839L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	@Column(name = "movie_name")
	private String moviename;
	@NotNull
	@Column(name = "release_year")
	private Integer releaseyear;
	
	@Column(name = "release_date")
	private Date releasedate;
	
	@Column(name = "movie_director")
	private String director;
	
	@Column(name = "movie_producer")
	private String producer;
	
	@Column(name = "movie_story")
	private String story;
	
	@Column(name = "movie_duration")
	private Long duration;
	
	@Column(name = "movie_synopsis")
	private String synopsis;
	
	@Column(name = "movie_path")
	private String moviepath;
	
	@Column(name = "movie_trailer_url")
	private String trailerurl;
	
	@Column(name = "actors")
	private String actorIds;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "actor_movie", joinColumns = { 
			@JoinColumn(name = "movie_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "actor_id", 
					nullable = false, updatable = false) })
	private Set<Actor> actors = new HashSet<Actor>(0);

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getActorIds() {
		return actorIds;
	}

	public void setActorIds(String actorIds) {
		this.actorIds = actorIds;
	}

	public Set<Actor> getActors() {
		return actors;
	}

	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}
	
}
