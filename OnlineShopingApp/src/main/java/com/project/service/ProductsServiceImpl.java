package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exception.CategoryNotFoundException;
import com.project.exception.ProductNotFoundException;
import com.project.model.CategoryEnum;
import com.project.model.Products;
import com.project.model.ProductsDTO;
import com.project.repository.ProductsDao;

@Service
public class ProductsServiceImpl implements ProductsService{
	
	@Autowired
	private ProductsDao psDao;
	
	@Override
	public Products addProducts(Products products) {
		// TODO Auto-generated method stub
		
		return psDao.save(products);
		
	}

	@Override
	public List<Products> getAllProducts() {
		// TODO Auto-generated method stub
		List<Products> list = psDao.findAll();
		
		if (list.size() > 0) {
			return list;
		} else
			throw new ProductNotFoundException("No products in catalog");
	}

	@Override
	public Products getProductsFromCatalogById(Integer id) {
		Optional<Products> opt = psDao.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}

		else
			throw new ProductNotFoundException("Product not found with given id");
	}

	@Override
	public List<ProductsDTO> getCategoryWiseProducts(CategoryEnum cat) {
		
		List<ProductsDTO> result= psDao.getCategoryWiseProducts(cat);
		
		return result;
	}

	@Override
	public String deleteProductFromCatalog(Integer id) throws ProductNotFoundException {
		
		Optional<Products> opt=	psDao.findById(id);
			
		if(opt.isPresent()) {
				Products prod = opt.get();
				psDao.delete(prod);
				return "Product deleted from catalog";
			} else
				throw new ProductNotFoundException("Product not found with given id");
	}

	@Override
	public Products updateProductIncatalog(Products product) throws ProductNotFoundException {

		Optional<Products> opt = psDao.findById(product.getProductId());

		if (opt.isPresent()) {
			opt.get();
			Products prod1 = psDao.save(product);
			return prod1;
		} else
			throw new ProductNotFoundException("Product not found with given id");
	}

	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	@Override
//	public List<Products> getProductsByCategory(CategoryEnum catename) {
//		// TODO Auto-generated method stub
//		
//		List<Products> list= psDao.findByCategory(catename);
//		
//		if (list.size() > 0) {
//
//			return list;
//		} else
//			throw new CategoryNotFoundException("No products found with category:" + catename);
//		
//	}
//
//
//	@Override
//	public java.util.List<ProductsDTO> funCategory(CategoryEnum cat) {
//		// TODO Auto-generated method stub
//		List<ProductsDTO> result=psDao.funCategory(cat);
//		
//		return result;
//		
//	}
//
//	@Override
//	public Products addProductsByCategory(CategoryEnum cat, Products products) {
//		// TODO Auto-generated method stub
//			
//		
//		return psDao.save(products);
//	}
//
//	@Override
//	public Products getProductFromCatalogById(Integer id) {
//		// TODO Auto-generated method stub
//		Optional<Products> opt = psDao.findById(id);
//		if (opt.isPresent()) {
//			return opt.get();
//		}
//
//		else
//			throw new ProductNotFoundException("Product not found with given id");
//	}
//
//	@Override
//	public Products getproductsById(int id) {
//		// TODO Auto-generated method stub
//		
//		return psDao.getproductsById(id);
//		
//	}
