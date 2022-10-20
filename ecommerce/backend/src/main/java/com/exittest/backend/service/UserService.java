package com.exittest.backend.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exittest.backend.dao.RoleDao;
import com.exittest.backend.dao.UserDao;
import com.exittest.backend.model.User;
import com.exittest.backend.model.UserRole;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	
	public List<User> getAllUser()
	{
		return this.userDao.findAll();
	}
	
	public User getUserByUserName(String userName)	
	{
		User user=this.userDao.findByUsername(userName);
		if(user!=null)
		{
			return user;
		}
		else
		{
			return null;
		}
			
	}
	
	public User addUser(User user,Set<UserRole> userRoles)
	{
		User userName=this.userDao.findByUsername(user.getUserName());
		if(userName!=null)
		{
			return null;
		}
		for(UserRole ur:userRoles)
		{
			this.roleDao.save(ur.getRole());
		}
		user.getUserRoles().addAll(userRoles);
		this.userDao.save(user);
		return user;
	}
	
	public User getUsertByUsernameAndPassword(String userName, String password)
	{
		User user=this.userDao.findByUsernameAndPassword(userName, password);
		if(user==null)
		{
			return null;
		}
		return user;
		
	}
	
	public Long getCountUser()
	{
		return this.userDao.count();
	}
	
}
