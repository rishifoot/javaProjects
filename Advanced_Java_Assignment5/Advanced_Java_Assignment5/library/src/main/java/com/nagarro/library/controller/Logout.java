

package com.nagarro.library.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles and fulfills the user logout request 
 */
@Controller
public class Logout {

	/* Logger class to give log messages of status */
	private static final Logger logger = LoggerFactory.getLogger(Logout.class);

	/**
	 * Handle logout procedure for user and remove all the set attributes
	 * @param request : HttpServletRequest -> request parameter generated
	 * @param response : HttpServletResponse -> response to fulfill the user request
	 * @throws IOException -> while redirecting it may throw an exception
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public void logout(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		
		logger.info("Logging out...");
		request.getSession().removeAttribute("username");		

		response.sendRedirect("./");
	}
}
