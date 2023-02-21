package com.prodDetailService.model;

//import javax.persistence.Entity;
//import javax.persistence.Id;


public class Product {
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int cid;
	private String design;
	private String brand;
	private String size;
	private int price;
	private Integer id;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getDesign() {
		return design;
	}
	public void setDesign(String design) {
		this.design = design;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "prodView [cid=" + cid + ", design=" + design + ", brand=" + brand + ", size=" + size + ", price="
				+ price + ", id=" + id + "]";
	}
	public Product(int cid, String design, String brand, String size, int price, Integer id) {
		super();
		this.cid = cid;
		this.design = design;
		this.brand = brand;
		this.size = size;
		this.price = price;
		this.id = id;
	}
	
}
