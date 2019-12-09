package com.boot.model;

public class ActorVO {
	
	private Long actorId;
	private String actorname;
	private String actorpath;
	
	public ActorVO(Long actorId, String actorname, String actorpath){
		this.actorId = actorId;
		this.actorname = actorname;
		this.actorpath = actorpath;
	}

	public Long getActorId() {
		return actorId;
	}

	public void setActorId(Long actorId) {
		this.actorId = actorId;
	}

	public String getActorname() {
		return actorname;
	}

	public void setActorname(String actorname) {
		this.actorname = actorname;
	}

	public String getActorpath() {
		return actorpath;
	}

	public void setActorpath(String actorpath) {
		this.actorpath = actorpath;
	}
	
	

}
