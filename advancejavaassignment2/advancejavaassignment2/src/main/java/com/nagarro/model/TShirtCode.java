package com.nagarro.model;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
public class TShirtCode {
	
	@Id
	private String brandName;
	private String brandCode;
	
	@OneToMany(mappedBy = "TShirtbrandCode")
	@Cascade(value = { CascadeType.DELETE, CascadeType.SAVE_UPDATE })
	public List<TShirt> tshirt;

	public TShirtCode(String brandName, String brandCode, List<TShirt> tshirt) {
		super();
		this.brandName = brandName;
		this.brandCode = brandCode;
		this.tshirt = tshirt;
	}

	public TShirtCode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getBrandName() {
		return brandName;
	}

	public String getBrandCode() {
		return brandCode;
	}

	public List<TShirt> getTshirt() {
		return tshirt;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

	public void setTshirt(List<TShirt> tshirt) {
		this.tshirt = tshirt;
	}
	
	
	
	
	
}
