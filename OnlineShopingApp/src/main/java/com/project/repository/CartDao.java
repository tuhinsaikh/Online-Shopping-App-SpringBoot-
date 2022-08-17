package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.model.Cart;

@Repository
public interface CartDao extends JpaRepository<Cart, Integer> {
	
	@Modifying
    @Query(
            value = "truncate table Cart",
            nativeQuery = true
    )
	public void DeleteAll();
	
	
//	public Cart deleteFromCart(Integer id);
	
//	public List<Cart> find
	
	
}
