package com.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.boot.dao.UserDAO;
import com.boot.model.UserAuthRequest;

@Service
public class UserService{

	@Autowired
	private UserDAO userDAO;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public String registerUser(UserAuthRequest userRequest) {
		userDAO.registerUser(userRequest);
		return "Success";
	}

}
