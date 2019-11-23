package com.boot.dao;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public class UserAuthDAO {
	
	@Autowired 
	private SessionFactory sessionFactory;
	
	public UserDetails getUserInfo(String username){
		UserDetails userDetails = null;
    	String sql = "SELECT u.user_name name, u.user_pwd pass, r.user_role role FROM "+
    			     "user u INNER JOIN user_role r on u.user_name=r.user_name WHERE "+
    			     "u.user_name = ?";
    	Session session = sessionFactory.openSession();
    	List<Object[]> users = session.createNativeQuery(sql).setParameter(1, username).list();
    	for (Object[] objects : users) {
            String name = (String)objects[0];
            String password = (String)objects[1];
            String role = (String)objects[2];
            GrantedAuthority authority = new SimpleGrantedAuthority(role);
            userDetails = (UserDetails)new User(name, password, Arrays.asList(authority));
         }
    	return userDetails;
    }
}
