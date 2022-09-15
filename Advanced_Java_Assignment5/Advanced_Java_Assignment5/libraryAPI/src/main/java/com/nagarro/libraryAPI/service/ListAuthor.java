
package com.nagarro.libraryAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.libraryAPI.dao.AuthorDao;
import com.nagarro.libraryAPI.entity.Author;

/**
 * The class provides url mappings to access Author list from database
 */
@RestController
public class ListAuthor {
	
	@Autowired
	private AuthorDao authorDao;
	
	/**
	 * Get List<Author> from database
	 */
	@RequestMapping(value = "/listauthors", method = RequestMethod.GET)
	public List<Author> listAuthors() {
		List<Author> authors = (List<Author>) authorDao.findAll();
		return authors;
	}
}