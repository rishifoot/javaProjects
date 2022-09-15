

package com.nagarro.library.auth;

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.nagarro.library.entity.User;

/**
 * Run query on database and authenticate user for username and password entered
 */
public class Authenticate {
	
	/**
	 * Run query on database and authenticate user for username and password entered
	 * 
	 * @param username : String -> unique username of user
	 * @param password : String -> password against username
	 * @param ht : HibernateTemplate -> to obtain session of database and run query
	 * @return boolean -> boolean value based on user is authentic or not
	 */
	public static boolean isAuthentic(String username, String password, HibernateTemplate ht) {
		
		/*
		 * Fetch user row form database where username as primary key ID
		 */
		User user = ht.get(User.class, username);
		
		/* If the entered username does not exist in database return false */
		if (user == null) {
			return false;
		}
		
		/* If user is found and password is correct return true */
		if (user.getPassword().equals(password)) {
			return true;
		}
		
		
		return false;
	}
}
