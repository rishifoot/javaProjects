package com.exittest.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exittest.backend.dao.UserDao;
import com.exittest.backend.model.User;
@Service
public class CustomUserDetailService implements UserDetailsService{
	@Autowired
	private UserDao userDao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=this.userDao.findByUsername(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("No user found");
		}
		
		return user;
	}

}
