package com.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.model.Cart;
import com.project.model.Products;

@Service
public interface CartService {
		
//	public Cart addProductToCart(Cart cart,String Name, Integer quantity);
	
	public Cart AddProduct(Cart cart,Integer id,Integer custId);
	
	public List<Cart> ViewAllCart();
	
}
