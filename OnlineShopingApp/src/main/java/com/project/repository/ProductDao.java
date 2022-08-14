package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Products;



@Repository
public interface ProductDao extends JpaRepository<Products, Integer>{

	List<Products> findByProductName(String productName);
}
