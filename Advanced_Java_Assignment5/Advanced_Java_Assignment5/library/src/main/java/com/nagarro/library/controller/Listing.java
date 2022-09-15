
package com.nagarro.library.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Listing {

	/* Logger class to give log messages of status */
	private static final Logger logger = LoggerFactory.getLogger(Listing.class);

	
	@RequestMapping("/listing")
	public String listing() {
		
		logger.info("Welcome to library");
		return "listing";
	}
}
