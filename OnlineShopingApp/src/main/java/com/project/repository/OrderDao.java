package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.Order;



public interface OrderDao extends JpaRepository<Order, Integer>{

}
