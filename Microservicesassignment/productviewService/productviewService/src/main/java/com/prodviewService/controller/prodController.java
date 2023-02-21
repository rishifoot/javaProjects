package com.prodviewService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prodviewService.model.Product;
import com.prodviewService.service.viewService;
@RestController
@RequestMapping("/view")
public class prodController {

	@Autowired
	private viewService viewservice;
	
	@GetMapping("/prod")
	public List<Product> allProduct(){
		return this.viewservice.getallProduct();
	}
	
	@GetMapping("/prod/{id}")
	public List<Product> getProductId(@PathVariable("id") Integer id)
	{
		return this.viewservice.getProductbyId(id);
	}
}
