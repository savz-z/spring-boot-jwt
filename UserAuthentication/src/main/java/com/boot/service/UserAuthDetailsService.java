package com.boot.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.boot.dao.UserAuthDAO;
import com.boot.model.UserAuthRequest;
import com.boot.model.UserInfo;

@Service
public class UserAuthDetailsService implements UserDetailsService {

	@Autowired
	private UserAuthDAO userDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo userInfo = userDAO.getUserInfo(username);
		GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getRole());
		UserDetails userDetails = (UserDetails)new User(userInfo.getUserName(), 
				userInfo.getPassword(), Arrays.asList(authority));
		return userDetails;
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public String registerUser(UserAuthRequest userRequest) {
		userDAO.registerUser(userRequest);
		return "Success";
	}

}
