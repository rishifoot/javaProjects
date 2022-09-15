
package com.nagarro.libraryAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.libraryAPI.entity.Book;

/**
 * The class provides CRUD operations for Book table and extends JpaRepository.
 */
public interface BookDao extends JpaRepository<Book, Integer> {

}
