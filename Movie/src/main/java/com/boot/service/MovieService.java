package com.boot.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boot.dao.MovieDAO;
import com.boot.entity.Actor;
import com.boot.entity.Movie;
import com.boot.model.ActorVO;
import com.boot.model.MovieVO;

@Service
public class MovieService {

	@Autowired
	private MovieDAO movieDAO;
	
	public List<MovieVO> getMovies(){
		List<MovieVO> moviesList = new ArrayList<MovieVO>();
		List<Movie> movies = movieDAO.getMovies();
		moviesList = movies.stream().map(x -> 
		new MovieVO(x.getId(),x.getMoviename(), x.getReleasedate(), x.getDirector(),x.getMoviepath(),x.getProducer(),x.getStory(),x.getDuration())).collect(Collectors.toList());
		return moviesList;
	}
	
	public List<MovieVO> getMoviesByYear(int year){
		List<MovieVO> moviesList = new ArrayList<MovieVO>();
		List<Movie> movies = movieDAO.getMoviesByYear(year);
		moviesList = movies.stream().map(x -> 
		new MovieVO(x.getId(),x.getMoviename(), x.getReleasedate(), x.getDirector(),x.getMoviepath(),x.getProducer(),x.getStory(),x.getDuration())).collect(Collectors.toList());
		return moviesList;
	}
	
	public MovieVO getMovieDetails(int id){
		Movie movie = movieDAO.getMovieDetails(Long.valueOf(id));
		MovieVO movieVO = new MovieVO();
		movieVO.setMovieid(movie.getId());
		movieVO.setMoviename(movie.getMoviename());
		movieVO.setDirector(movie.getDirector());
		movieVO.setMoviepath(movie.getMoviepath());
		movieVO.setSynopsis(movie.getSynopsis());
		movieVO.setTrailerurl(movie.getTrailerurl());
		movieVO.setReleasedate(movie.getReleasedate());
		movieVO.setReleaseyear(movie.getReleaseyear());	
		movieVO.setProducer(movie.getProducer());
		movieVO.setStory(movie.getStory());
		movieVO.setDuration(movie.getDuration());
		Set<Actor> actors = movie.getActors();
		movieVO.setActors(actors.stream().map(x-> new ActorVO(x.getId(), x.getActorame(), x.getActorpath())).collect(Collectors.toList()));
		return movieVO;
		
	}
	
	@Transactional
	public Movie addMovie(Movie movie){
		return movieDAO.addMovie(movie);
	}
	
	@Transactional
	public Movie updateMovie(Movie movie){
		return movieDAO.updateMovie(movie);
	}
	
	@Transactional
	public boolean deleteMovie(int movieId){
		return movieDAO.deleteMovie(movieId);
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
