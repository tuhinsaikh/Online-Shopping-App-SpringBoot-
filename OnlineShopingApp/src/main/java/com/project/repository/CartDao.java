package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Cart;

@Repository
public interface CartDao extends JpaRepository<Cart, Integer> {
	
	public Cart findByCartItemId(Integer cartItemId);
	
	
	
	
}
