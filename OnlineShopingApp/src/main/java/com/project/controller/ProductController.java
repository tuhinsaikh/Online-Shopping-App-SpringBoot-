package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Products;
import com.project.service.ProductService;

@RestController
public class ProductController {
	
		@Autowired
		private ProductService pService;
		
		
		@PostMapping("/products")
		public Products saveProductHandler(@RequestBody Products product) {
			
			return pService.saveProduct(product);
		}
		
}
