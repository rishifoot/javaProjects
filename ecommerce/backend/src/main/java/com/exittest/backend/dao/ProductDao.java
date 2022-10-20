package com.exittest.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exittest.backend.model.Product;



@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
	public List<Product> findByProductName(String productName);
	public List<Product> findByProductId(int productId);
	public List<Product> findByProductBrand(String productBrand);
	public List<Product> findByProductCode(int productCode);
//	public List<Serviceavailibility>  findProductService(int pincode);
}
