package com.prodDetailService.model;

import java.util.ArrayList;
import java.util.List;

public class prodName {

	public prodName() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Integer id;
	private String name;
	List<Product> product=new ArrayList<>();
	@Override
	public String toString() {
		return "prodName [id=" + id + ", name=" + name + ", product=" + product + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public prodName(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public prodName(Integer id, String name, List<Product> product) {
		super();
		this.id = id;
		this.name = name;
		this.product = product;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
}
