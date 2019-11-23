package com.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.dao.MovieDAO;
import com.boot.model.Movie;

@Service
public class MovieService {

	@Autowired
	private MovieDAO movieDAO;
	
	public List<Movie> getMovies(){
		return movieDAO.getMovies();
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
