package com.exittest.backend.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exittest.backend.dao.ProductDao;
import com.exittest.backend.dao.ServiceavailibilityDao;
import com.exittest.backend.model.Product;
import com.exittest.backend.model.Serviceavailibility;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao;
//	@Autowired
//	private ServiceavailibilityDao serviceavailibilityDao;
	/***
	 * get all products
	 * @return
	 */
	public List<Product> getProduct()
	{
		return this.productDao.findAll();
	}
	/***
	 * 
	 * @param product
	 * @return save the products
	 */
	
	public Product addProduct(Product product)
	{
//		Product productId=this.productDao.findByProductId(product.getProductId());
//		System.out.println(productId);
//		if(productId!=null)
//		{
//			return null;
//		}
		return this.productDao.save(product);
	}
	
	public List<Product> getProductByName(String productName)
	{
		List<Product> product= this.productDao.findByProductName(productName);
		return product;
	}
	public List<Product> getProductById(int productId) {
	
		
		List<Product> product= this.productDao.findByProductId(productId);
		return product;
	}
	
	public Long getNumberofProducts()
	{
		return this.productDao.count();
	}
	public List<Product> getProductByBrand(String productBrand)
	{
		List<Product> product= this.productDao.findByProductBrand(productBrand);
		return product;
	}
	public List<Product> getProductByCode(int productCode)
	{
		List<Product> product= this.productDao.findByProductCode(productCode);
		return product;
	}
	

	
}
