package com.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.model.CategoryEnum;
import com.project.model.Products;
import com.project.model.ProductsDTO;


@Repository
public interface ProductsDao extends JpaRepository<Products, Integer> {
	
	public List<Products>  findByProductName(String productName);
	
//	@Query("select new com.project.model.ProductsDTO(p.productName, p.price) from Products p where p.productId=?1")
//	public Products getproductsById(int id);
	
	@Query("select new com.project.model.ProductsDTO(p.productName, p.price) from Products p where p.category=?1")
	public List<ProductsDTO> getCategoryWiseProducts(CategoryEnum cat);

}
