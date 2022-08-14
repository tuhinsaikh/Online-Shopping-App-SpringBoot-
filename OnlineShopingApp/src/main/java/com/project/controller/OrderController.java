package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.MyOrder;
import com.project.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderservice;
	
	@PostMapping("/{customerId}/{addressId}")
	public ResponseEntity<MyOrder>addorder(@RequestBody MyOrder order,@PathVariable Integer customerId,@PathVariable Integer addressId){
		MyOrder uporder= orderservice.addOrder(order, customerId, addressId);
		return new ResponseEntity<MyOrder>(uporder,HttpStatus.ACCEPTED);
	}

}
