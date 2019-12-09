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

import com.boot.entity.Movie;
import com.boot.model.MovieVO;
import com.boot.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value = "/movies", method = RequestMethod.GET)
	public ResponseEntity<?> getMovies(){
		List<MovieVO> movies = movieService.getMovies();
		return ResponseEntity.ok(movies);
	}
	
	@RequestMapping(value = "/movies/{year}", method = RequestMethod.GET)
	public ResponseEntity<?> getMoviesByYear(@PathVariable("year") int year){
		List<MovieVO> movies = movieService.getMoviesByYear(year);
		return ResponseEntity.ok(movies);
	}
	
	@RequestMapping(value = "/movie/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getMovieDetails(@PathVariable("id") int id){
		MovieVO movie = movieService.getMovieDetails(id);
		return ResponseEntity.ok(movie);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/movie/add", method = RequestMethod.POST)
	public ResponseEntity<?> addMovie(@RequestBody Movie movie){
		Movie resMovie = movieService.addMovie(movie);
		return ResponseEntity.ok(resMovie);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/movie/edit", method = RequestMethod.PUT)
	public ResponseEntity<?> updatetMovie(@RequestBody Movie movie){
		Movie resMovie = movieService.updateMovie(movie);
		return ResponseEntity.ok(resMovie);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/movie/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteMovie(@PathVariable("id") int movieId){
		boolean status = movieService.deleteMovie(movieId);
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
