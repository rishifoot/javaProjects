package com.nagarro.libraryAPI.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.nagarro.libraryAPI.model.BookModel;

@Entity
public class Book {

	@Id
	private int id;
	private String name;
	private String author;
	private Date date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public void setData(BookModel book) {
		
		this.id = book.getId();
		this.name = book.getName();
		this.author = book.getAuthor();
		this.date = new Date();
	}

	@Override
	public String toString() {
		return "Book [id=" + this.id + ", name=" + this.name + ", author=" + this.author + ", date=" + this.date;
	}
}
