package com.exittest.backend.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.exittest.backend.model.Product;
import com.exittest.backend.model.Serviceavailibility;
import com.exittest.backend.service.ProductService;
import com.exittest.backend.service.ServiceavailibilityService;

//product Controller

@CrossOrigin("*")
@RequestMapping("/api")
@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ServiceavailibilityService serviceavailibilityService;
//	@CrossOrigin("http://localhost:4200")
	@CrossOrigin("*")
	@GetMapping("/all-products")
	public List<Product> getAllProduct()
	{
		return this.productService.getProduct();
	}
	@CrossOrigin()
	@PostMapping("/add-products")
	public Product addProduct(@RequestBody Product product)
	{
		return this.productService.addProduct(product);
	}
	
	
	@SuppressWarnings("rawtypes")
	@CrossOrigin("*")
	@GetMapping("/search/{productName}")
	public ResponseEntity getproductByName(@PathVariable String productName)
	{
		List<Product>  product = this.productService.getProductByName(productName);

		if (product == null) {
			return ResponseEntity.status(401).build();
		}
		return ResponseEntity.status(200).body(product);
	}
	@SuppressWarnings("rawtypes")
	@CrossOrigin("*")
	@GetMapping("/producta/{productId}")
	public ResponseEntity  productById(@PathVariable int productId)
	{
		List<Product>  product =this.productService.getProductById(productId);
		if (product == null) {
			return ResponseEntity.status(401).build();
		}
		return ResponseEntity.status(200).body(product);
		
	}  
	
	@GetMapping("/count-products")
	public Long getProductCount()
	{
		return this.productService.getNumberofProducts();
	}
	@SuppressWarnings("rawtypes")
	@CrossOrigin("*")
	@GetMapping("/productb/{productBrand}")
	public ResponseEntity  productByBrand(@PathVariable String productBrand)
	{
		List<Product>  product =this.productService.getProductByBrand(productBrand);
		if (product == null) {
			return ResponseEntity.status(401).build();
		}
		return ResponseEntity.status(200).body(product);
		
	}
	
	@SuppressWarnings("rawtypes")
	@CrossOrigin("*")
	@GetMapping("/productc/{productCode}")
	public ResponseEntity  productByCode(@PathVariable int productCode)
	{
		List<Product>  product =this.productService.getProductByCode(productCode);
		if (product == null) {
			return ResponseEntity.status(401).build();
		}
		return ResponseEntity.status(200).body(product);
		
	}
	@SuppressWarnings("rawtypes")
	@CrossOrigin("*")
	@GetMapping("/service/{pincode}")
	public ResponseEntity  productByService(@PathVariable Long pincode)
	{
		
		List<Serviceavailibility> product =this.serviceavailibilityService.getProductByService(pincode);
		if (product == null) {
			return ResponseEntity.status(401).build();
		}
		return ResponseEntity.status(200).body(product);
		
	}
}
