package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.Actor;
import com.boot.model.ActorVO;
import com.boot.model.MovieVO;
import com.boot.service.ActorService;

@RestController
public class ActorController {

	@Autowired
	private ActorService actorService;
	
	@RequestMapping(value = "/actors", method = RequestMethod.GET)
	public ResponseEntity<?> getMovies(){
		List<ActorVO> movies = actorService.getActors();
		return ResponseEntity.ok(movies);
	}
	
	
	@RequestMapping(value = "/actor/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getActorDetails(@PathVariable("id") int id){
		ActorVO actor = actorService.getActorDetails(id);
		return ResponseEntity.ok(actor);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/actor/add", method = RequestMethod.POST)
	public ResponseEntity<?> addActor(@RequestBody Actor actor){
		Actor resActor = actorService.addActor(actor);
		return ResponseEntity.ok(resActor);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/actor/edit", method = RequestMethod.PUT)
	public ResponseEntity<?> updatetMovie(@RequestBody Actor actor){
		Actor resActor = actorService.updateActor(actor);
		return ResponseEntity.ok(resActor);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/actor/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteMovie(@PathVariable("id") int movieId){
		boolean status = actorService.deleteActor(movieId);
		return ResponseEntity.ok(status);
	}

	/*
	 * @RequestMapping(value = "/login", method = RequestMethod.POST) public
	 * ResponseEntity<?> login(@RequestBody UserAuthRequest authReq) throws
	 * Exception { authenticateUserDetails(authReq.getUsername(),
	 * authReq.getPassword());
	 * 
	 * final UserDetails userDetails =
	 * userDetailsService.loadUserByUsername(authReq.getUsername()); final String
	 * token = jwtTokenUtil.generateToken(userDetails); UserAuthResponse res = new
	 * UserAuthResponse(); res.setToken(token);
	 * res.setUsername(userDetails.getUsername()); return ResponseEntity.ok(res);
	 * 
	 * }
	 * 
	 * private void authenticateUserDetails(String userName, String password) throws
	 * Exception { try { authManager.authenticate(new
	 * UsernamePasswordAuthenticationToken(userName, password)); } catch
	 * (DisabledException e) { throw new Exception("USER_DISABLED", e); } catch
	 * (BadCredentialsException e) { throw new Exception("INVALID_CREDENTIALS", e);
	 * } }
	 * 
	 * @RequestMapping(value = "/register", method = RequestMethod.POST) public
	 * ResponseEntity<?> registerUser(@RequestBody UserAuthRequest authReq) throws
	 * Exception { userDetailsService.registerUser(authReq); return
	 * ResponseEntity.ok("200"); }
	 */

}