

package com.nagarro.library.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.library.auth.Authenticate;

/**
 * Listen to the user login request and handle the procedure.<br />
 * Create some session attributes to be used during a user login session.
 */
@Controller
public class Login {
	
	/* Logger class to give log messages of status */
	private static final Logger logger = LoggerFactory.getLogger(Login.class);
	
	/*
	 * Hibernate session to make connection with database
	 * Obtained form Spring bean defined in /spring/root-context.xml file
	 */
	@Autowired
	private HibernateTemplate ht;
	
	/**
	 * Listen to user POST request to login on "/login"
	 * @param username : String -> username from form field
	 * @param password : String -> password from form field
	 * @throws IOException 
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(@RequestParam("username") String username,
			@RequestParam("password") String password,
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		logger.info("Logging in...");
		
		/* Run user authentication method */
		if (Authenticate.isAuthentic(username, password, ht)) {
			
			logger.info("Login Successful");
			request.getSession().setAttribute("username", username);
			response.sendRedirect("./listing");

		} else {
			
			logger.error("Login Failed");
			response.sendRedirect("./");
		}
	}
}
