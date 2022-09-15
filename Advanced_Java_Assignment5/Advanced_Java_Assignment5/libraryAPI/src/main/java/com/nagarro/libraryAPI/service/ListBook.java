
package com.nagarro.libraryAPI.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.libraryAPI.dao.BookDao;
import com.nagarro.libraryAPI.entity.Book;
import com.nagarro.libraryAPI.model.BookModel;

/**
 * The class provides various url mapping to perform database operation on Book table
 */
@RestController
@CrossOrigin(origins = "*")
public class ListBook {

	private static final Logger logger = LoggerFactory.getLogger(ListBook.class);
	
	@Autowired
	private BookDao bookDao;

	/**
	 * Add a new Book to database
	 * @param bookModel
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/addbook", method = RequestMethod.POST)
	public void addBook(@ModelAttribute BookModel bookModel,
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Book book = new Book();
		book.setData(bookModel);
		if (book.getId() != 0) {
			logger.info("Adding Book : " + book.toString());
			bookDao.save(book);
		}
		else {
			logger.error("Cannot add Book with Book.id : 0");
		}
		response.sendRedirect(request.getHeader("referer") + "library/listing");
	}
	
	/**
	 * Update the Book details if exist or else add the Book to database
	 * @param id
	 * @param name
	 * @param author
	 */
	@RequestMapping(value = "/updatebook/{id}/{name}/{author}", method = RequestMethod.PUT)
	public void updateBook(@PathVariable("id") int id,
			@PathVariable("name") String name,
			@PathVariable("author") String author) {
		Book book  = new Book();
		book.setId(id);
		book.setName(name);
		book.setAuthor(author);
		book.setDate(new Date());
		if (book.getId() == 0) {
			logger.error("Cannot update Book with ID = " + id);
		} else {
			logger.info("Saving Book : " + book.toString());
			bookDao.save(book);
		}
	}
	
	/**
	 * Delete a Book form database
	 * @param id
	 */
	@RequestMapping(value = "/deletebook/{id}", method = RequestMethod.DELETE)
	public void deleteBook(@PathVariable("id") int id) {
		Book book = bookDao.getById(id);
		if (book.getId() == 0) {
			logger.error("No such book in database");
		} else {
			logger.info("Deleteing Book : " + book.toString());
			bookDao.delete(book);
		}
	}
	
	/**
	 * Get a List of all Book from database
	 * @return
	 */
	@RequestMapping(value = "/listbook", method = RequestMethod.GET)
	public List<Book> listBook() {
		logger.info("Listing Books");
		List<Book> book = (List<Book>) bookDao.findAll();
		return book;
	}
}
