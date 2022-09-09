package com.nagarro.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
@Entity
public class TshirtCode {
	@Id
	private String brandName;
	private String brandCode;

	@OneToMany(mappedBy = "TshirtbrandCode")
	@Cascade(value = { CascadeType.DELETE, CascadeType.SAVE_UPDATE })
	public List<Tshirt> tshirt;

	public TshirtCode(String brandName, String brandCode, List<Tshirt> tshirt) {
		super();
		this.brandName = brandName;
		this.brandCode = brandCode;
		this.tshirt = tshirt;
	}

	public TshirtCode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getBrandName() {
		return brandName;
	}

	public String getBrandCode() {
		return brandCode;
	}

	public List<Tshirt> getTshirt() {
		return tshirt;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

	public void setTshirt(List<Tshirt> tshirt) {
		this.tshirt = tshirt;
	}

}
