package com.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.model.CategoryEnum;
import com.project.model.Products;

@Repository
public interface ProductsDao extends JpaRepository<Products, Integer> {
	
//	@Query("select p.productName,p.price from Products p where p.category=:catenum")
//	public List<Products> getAllProductsInACategory(@Param("catenum") CategoryEnum catenum);
	
	public List<Products>  findByProductName(String productName);
	
	
//	@Query("from Products p.category=?1")
//	public List<Products> getAllProductsByCategory(@Param("category") String category);
		
   
}
