package com.boot.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.boot.model.Role;
import com.boot.model.User;
import com.boot.model.UserAuthRequest;

@Repository
public class UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
 
	public void registerUser(UserAuthRequest userRequest) {
	    	User user = new User();
	    	user.setUsername(userRequest.getUsername());
	    	user.setPassword(new BCryptPasswordEncoder().encode(userRequest.getPassword()));
	    	user.setEmail(userRequest.getEmail());
	    	user.setContact(userRequest.getContact());
	    	Role role = new Role();
	    	role.setUsername(user.getUsername());
	    	role.setRole("USER");
	    	Set<Role> roles = new HashSet<Role>();
	    	roles.add(role);
	    	user.setRoles(roles);
	    	Session session = sessionFactory.openSession();
	    	session.save(user);
	    }

}
