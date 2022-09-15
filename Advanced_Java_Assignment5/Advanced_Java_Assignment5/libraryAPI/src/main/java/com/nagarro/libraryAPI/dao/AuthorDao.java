
package com.nagarro.libraryAPI.dao;

import org.springframework.data.repository.CrudRepository;

import com.nagarro.libraryAPI.entity.Author;

/**
 * The class provides CRUD operations for Author table and extends CrudRepository
 */
public interface AuthorDao extends CrudRepository<Author, Integer> {

}
