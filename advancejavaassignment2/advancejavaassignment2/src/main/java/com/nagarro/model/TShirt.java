package com.nagarro.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class TShirt {

	@Id
	private String id;
	private String name;
	private String color;
	private String gender;
	private String size;
	private float price;
	private float rating;
	private String availability;
    
	@ManyToOne
	@JoinColumn(name = "brandName")
	@Cascade(value = { CascadeType.DELETE, CascadeType.SAVE_UPDATE })
	private TShirtCode TShirtbrandCode;

	
	
	
	
	public TShirt(String id, String name, String color, String gender, String size, float price, float rating,
			String availability, TShirtCode tShirtbrandCode) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.gender = gender;
		this.size = size;
		this.price = price;
		this.rating = rating;
		this.availability = availability;
		TShirtbrandCode = tShirtbrandCode;
	}



	public TShirt() {
		super();
		
	}



	public TShirtCode getTShirtbrandCode() {
		return TShirtbrandCode;
	}



	public void setTShirtbrandCode(TShirtCode tShirtbrandCode) {
		TShirtbrandCode = tShirtbrandCode;
	}



	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getColor() {
		return color;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getSize() {
		return size;
	}
	
	public float getPrice() {
		return price;
	}
	
	public float getRating() {
		return rating;
	}
	
	public String getAvailability() {
		return availability;
	}
	
//	SETTERS
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setSize(String size) {
		this.size = size;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public void setRating(float rating) {
		this.rating = rating;
	}
	
	public void setAvailability(String availability) {
		this.availability = availability;
	}



	@Override
	public String toString() {
		return "TShirt [id=" + id + ", name=" + name + ", color=" + color + ", gender=" + gender + ", size=" + size
				+ ", price=" + price + ", rating=" + rating + ", availability=" + availability + "]";
	}
    
    
	
}
