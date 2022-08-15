package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Cart;

@Repository
public interface CartDao extends JpaRepository<Cart, Integer> {
	
	
	
}
