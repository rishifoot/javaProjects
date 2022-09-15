
package com.nagarro.library.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.library.entity.Author;
import com.nagarro.library.entity.Book;

/**
 * The class reads the response from URL and parse the JSON to List of objects
 */
public class JsonToObject {

	/**
	 * Parser JSON response to List<Book>
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public List<Book> getBooks(String url) throws IOException {
        URL jsonpage = new URL(url);
        URLConnection urlcon = jsonpage.openConnection();
        BufferedReader buffread = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));
        String recieve = buffread.readLine();
        buffread.close();
		return new ObjectMapper().readValue(recieve, new TypeReference<List<Book>>(){});
	}
	
	/**
	 * Parse JSON response to List<Author>
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public List<Author> getAuthors(String url) throws IOException {
		URL jsonpage = new URL(url);
        URLConnection urlcon = jsonpage.openConnection();
        BufferedReader buffread = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));
        String recieve = buffread.readLine();
        buffread.close();
		return new ObjectMapper().readValue(recieve, new TypeReference<List<Author>>(){});
	}
}
