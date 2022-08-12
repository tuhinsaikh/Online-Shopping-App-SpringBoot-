package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Category;
import com.project.model.Course;
import com.project.model.Product;
import com.project.repository.CategoryDao;
import com.project.repository.ProductDao;

@Service
public class ProductServiceImpl implements ProductService{

	
	@Autowired
	private ProductDao pDao;
	
	@Autowired
	private CategoryDao cDao;
	
	
	@Override
	public Product saveProduct(Product product) {
		
		List<Category> categories= product.getCategories();
		
		for(Category cat:categories) {
			
			cat.getProducts().add(product);
			cDao.save(cat);
		}
		
		return pDao.save(product);
	}

	
		
}
