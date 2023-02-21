package com.prodDetailService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.prodDetailService.model.Product;
import com.prodDetailService.model.prodName;
import com.prodDetailService.service.productService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class productController {
	@Autowired
	private productService prodService;
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/all-products")
	public List<prodName> getAllProduct()
	{
		return this.prodService.getProduct();
	}
	
	@PostMapping("/add-products")
	public void addProduct(@RequestBody prodName product)
	{
		prodService.addProduct(product);
	}

	@RequestMapping("/prod/{id}")
	public prodName productbyId(@PathVariable("id") Integer id) {
		prodName prodname =this.prodService.getProductById(id);
		List products = this.restTemplate.getForObject("http://product-service/view/prod/" +prodname.getId() , List.class);
		prodname.setProduct(products);
		return prodname;
		
		
	}
}
