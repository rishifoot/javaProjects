package com.prodDetailService.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//
//import com.prodDetailService.dao.productDao;
import com.prodDetailService.model.Product;
import com.prodDetailService.model.prodName;

@Service
public class productService {
	
	private List<prodName> list = new ArrayList<>(List.of(
            new prodName(1311,"phone"))
            
    );

	public List<prodName> getProduct()
	{
		return list;
	}
	
	public void addProduct(prodName product) {
		list.add(product);
	}
	
	public prodName getProductById(Integer id)
	{
		return list.stream().filter(Prod -> Prod.getId().equals(id)).findAny().orElse(null);
	}
}
