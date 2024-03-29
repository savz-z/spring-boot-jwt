package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.UserAuthRequest;
import com.boot.model.UserAuthResponse;
import com.boot.service.UserAuthService;
import com.boot.service.UserService;
import com.boot.util.JwtTokenUtil;

@RestController
public class UserController {

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private UserAuthService userAuthService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody UserAuthRequest authReq) throws Exception {
		authenticateUserDetails(authReq.getUsername(), authReq.getPassword());

		final UserDetails userDetails = userAuthService.loadUserByUsername(authReq.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		UserAuthResponse res  = new UserAuthResponse();
		res.setToken(token);
		res.setUsername(userDetails.getUsername());
		return ResponseEntity.ok(res);

	}

	private void authenticateUserDetails(String userName, String password) throws Exception {
		try {
			authManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> registerUser(@RequestBody UserAuthRequest authReq) throws Exception {
		userService.registerUser(authReq);
		return ResponseEntity.ok("200");
	}

}
