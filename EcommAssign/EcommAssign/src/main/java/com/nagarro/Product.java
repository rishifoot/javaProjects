package com.nagarro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column
	private String title;
	@Column
	private String quantity;
	@Column
	private String size;
	@Column
	private String image;
	
	public Product() {
		
	}
	
	public Product(int id, String title, String quantity, String size, String image) {
		super();
		this.id = id;
		this.title = title;
		this.quantity = quantity;
		this.size = size;
		this.image = image;
	}
	
	public Product(String title, String quantity, String size, String image) {
		super();
		this.title = title;
		this.quantity = quantity;
		this.size = size;
		this.image = image;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", quantity=" + quantity + ", size=" + size + ", image="
				+ image + "]";
	}
	
	
}
