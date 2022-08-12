package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Product;
import com.project.service.ProductService;

@RestController
public class ProductController {
	
		@Autowired
		private ProductService pService;
		
		
		@PostMapping("/products")
		public Product saveProductHandler(@RequestBody Product product) {
			
			return pService.saveProduct(product);
		}
		
}
