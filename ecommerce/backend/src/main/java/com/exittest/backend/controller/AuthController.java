 package com.exittest.backend.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.exittest.backend.config.jwtUtils;
import com.exittest.backend.model.User;
import com.exittest.backend.model.jwtRequest;
import com.exittest.backend.model.jwtResponse;
import com.exittest.backend.service.CustomUserDetailService;


@RestController
@CrossOrigin("*")
public class AuthController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private CustomUserDetailService customUserDetailService;
	@Autowired
	private jwtUtils jwtUtil;
	
	@PostMapping(value="/api/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody jwtRequest jwtRequest) throws Exception
	{
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("Bad Credetials");
			
		}
		UserDetails userDetails = this.customUserDetailService.loadUserByUsername(jwtRequest.getUsername());
		String token=this.jwtUtil.generateToken(userDetails);
		return  ResponseEntity.ok(new jwtResponse(token));
	}
	public void authenticate(String username, String password) throws Exception
	{
		try
		{
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}
		catch(Exception e)
		{
			throw new Exception("User Not Found");
			
		}
		
	}
	
	@GetMapping("/api/currentuser")
	public User getCurrentUser(Principal principal)
	{
		return ((User)(this.customUserDetailService.loadUserByUsername(principal.getName())));
		
	}
}
