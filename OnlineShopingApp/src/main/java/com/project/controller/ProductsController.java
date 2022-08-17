package com.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.CategoryEnum;
import com.project.model.Products;
import com.project.model.ProductsDTO;
import com.project.service.ProductsService;

@RestController
public class ProductsController {
	@Autowired
	private ProductsService ppService;
	
	
	@PostMapping("/addnewproducts")
	public Products saveProductsHandler(@Valid @RequestBody Products product) {
		
		return ppService.addProducts(product);
	}
	
	/////////////////////////////////////////////////////////////////
	
	@GetMapping("/allproducts")
	public List<Products> getAllProducts(){
		
		return ppService.getAllProducts();
	}
	/////////////////////////////////////////////////////////////////
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Products> getProductFromCatalogByIdHandler(@PathVariable("id") Integer id) {
		
		Products prod =  ppService.getProductsFromCatalogById(id);

		return new ResponseEntity<Products>(prod, HttpStatus.FOUND);

	}
/////////////////////////////////////////////////////////////////////
	@GetMapping("/products/{cat}")
	public List<ProductsDTO> getCategoryWiseProducts(@PathVariable("cat") CategoryEnum cat) {
	
		return ppService.getCategoryWiseProducts(cat);
		
	}
	
	//////////////////////////////////////////////////////////////////
	@DeleteMapping("/deleteproduct/{id}")
	public ResponseEntity<String> deleteProductFromCatalogHandler(@PathVariable("id") Integer id) {
		
		String res = ppService.deleteProductFromCatalog(id);
		return new ResponseEntity<String>(res, HttpStatus.OK);
	}
	
	///////////////////////////////////////////////////////////////////
	@PutMapping("/updateproducts")
	public ResponseEntity<Products> updateProductInCatalogHandler(@Valid @RequestBody Products prod) {

		Products prod1 = ppService.updateProductIncatalog(prod);

		return new ResponseEntity<Products>(prod1, HttpStatus.OK);

	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@GetMapping("/products/{id}")
//	public Products getProductsById(@PathVariable("id") Integer id) {
//		
//		return ppService.getProductFromCatalogById(id);
//	}
//	
//	/////////////////////////////////////////////////////////////////////
//	
//	@GetMapping("/test/{id}")
//	public Products getproductsById(@PathVariable("id") Integer id) {
//		
//		return ppService.getproductsById(id);
//	}
//	
//	///////////////////////////////////////////////////////
//	
//	@GetMapping("/category/{cat}")
//	public List<ProductsDTO> getfunctions(@PathVariable("cat") CategoryEnum cat) {
//		
//		return ppService.funCategory(cat);
//	}
//	
//	/////////////////////////////////////////////////////////////
//	@PostMapping("/addcategorywise/{cat}")
//	public Products addProductsByCategory(@RequestBody @PathVariable("cat") CategoryEnum cat, Products products) {
//		
//		return ppService.addProductsByCategory(cat, products);
//		
//	}
	
