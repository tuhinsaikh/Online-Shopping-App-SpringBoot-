package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.model.Category;
import com.project.repository.CategoryDao;
import com.project.repository.ProductDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Category;
import com.project.model.Product;
import com.project.repository.CategoryDao;
import com.project.repository.ProductDao;

@Service
public class CategoryServiceIml implements CategoryService{

	
	@Autowired
	private ProductDao pDao;
	
	@Autowired
	private CategoryDao cDao;
	
	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
//		List<Category> categories= product.getCategories();
//		
//		for(Category cat:categories) {
//			
//			cat.getProducts().add(product);
//			cDao.save(cat);
//		}
//		
//		return pDao.save(product);
		
	List<Product>	products=category.getProducts();
	
		if(products.size()!=0) {
			for(Product prd: products) {
				
				prd.setCategory(category);
				//pDao.save(prd);
				
			}
		}
			
	
	return cDao.save(category);
	 
		//return null;
	}

}
