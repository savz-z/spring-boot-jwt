package com.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boot.dao.ActorDAO;
import com.boot.entity.Actor;
import com.boot.model.ActorVO;

@Service
public class ActorService {

	@Autowired
	private ActorDAO actorDAO;
	
	public List<ActorVO> getActors(){
		List<ActorVO> actorsList = new ArrayList<ActorVO>();
		List<Actor> actors = actorDAO.getActors();
		
		return actorsList;
	}
	
	
	public ActorVO getActorDetails(int id){
		Actor actor = actorDAO.getActorDetails(Long.valueOf(id));
		ActorVO actorVO = new ActorVO();
		actorVO.setActorid(actor.getId());
		actorVO.setActorname(actor.getActorname());
		actorVO.setBirthdate(actor.getBirthdate());
		actorVO.setActordesc1(actor.getActordesc1());
		actorVO.setActordesc2(actor.getActordesc2());
		actorVO.setActordesc3(actor.getActordesc3());
		actorVO.setActordesc4(actor.getActordesc4());
		actorVO.setActordesc5(actor.getActordesc5());
		actorVO.setActorpath(actor.getActorpath());
		actorVO.setMovies(actorDAO.getMovieDetails(actorVO.getActorid()));
		return actorVO;
		
	}
	
	@Transactional
	public Actor addActor(Actor actor){
		return actorDAO.addActor(actor);
	}
	
	@Transactional
	public Actor updateActor(Actor actor){
		return actorDAO.updateActor(actor);
	}
	
	@Transactional
	public boolean deleteActor(int actorId){
		return actorDAO.deleteActor(actorId);
	}
	
	/*
	 * @Override public UserDetails loadUserByUsername(String username) throws
	 * UsernameNotFoundException { UserInfo userInfo =
	 * userDAO.getUserInfo(username); GrantedAuthority authority = new
	 * SimpleGrantedAuthority(userInfo.getRole()); UserDetails userDetails =
	 * (UserDetails)new User(userInfo.getUserName(), userInfo.getPassword(),
	 * Arrays.asList(authority)); return userDetails; }
	 * 
	 * @Transactional(propagation = Propagation.REQUIRES_NEW) public String
	 * registerUser(UserAuthRequest userRequest) {
	 * userDAO.registerUser(userRequest); return "Success"; }
	 */

}
