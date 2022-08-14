package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.CategoryEnum;
import com.project.model.Products;
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

	

	
	
}
