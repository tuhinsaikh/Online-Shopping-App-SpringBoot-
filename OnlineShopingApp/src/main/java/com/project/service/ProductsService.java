package com.project.service;

import java.util.List;

import com.project.model.CategoryEnum;
import com.project.model.Products;
import com.project.model.ProductsDTO;

public interface ProductsService {

	public Products addProducts(Products products);
	
	public List<Products> getAllProducts();
	
	public Products getProductsFromCatalogById(Integer id);
	
	public List<ProductsDTO> getCategoryWiseProducts(CategoryEnum cat);
	
	public String deleteProductFromCatalog(Integer id);
	
	public Products updateProductIncatalog(Products product);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public Products getproductsById(int id);
//	
//	
//	
//	
//	
//	public Products getProductFromCatalogById(Integer id);
//	
//	public List<Products> getProductsByCategory(CategoryEnum catename);
//	
//	
//	
//	public List<ProductsDTO> funCategory(CategoryEnum cat);
//	
//	public Products addProductsByCategory(CategoryEnum cat ,Products products);
	////////////////////////////////////////////
	//public List<Products> getAllProductsIncatalog();
}
