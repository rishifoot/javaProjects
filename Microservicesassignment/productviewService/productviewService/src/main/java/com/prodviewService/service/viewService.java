package com.prodviewService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.prodviewService.model.Product;



@Service
public class viewService {
	
	private List<Product> list=new ArrayList<>(List.of(
			new Product(13,"a1","poco","s",23456,1311),
			new Product(14,"ep","lenovo","s",67845,1312)));
	
	public List<Product> getallProduct()
	{
		return list;
	}
	public List<Product> getProductbyId(Integer id)
	{
		return list.stream().filter(Prod -> Prod.getId().equals(id)).collect(Collectors.toList());
	}
}
