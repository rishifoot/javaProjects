package com.prodDetailService.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		if(username.equals("rishikesh")) {
			return new User("rishikesh","parasar",new ArrayList<>());
		}else {
			throw new UsernameNotFoundException("user not found");
		}
	}

}
