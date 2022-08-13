package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	OrderService orderservice;
	@PostMapping("/")
	public ResponseEntity<MyOrder>saveOrde(@RequestBody MyOrder order){
		MyOrder myorder= orderservice.addorder(order);
		return new ResponseEntity<MyOrder>(myorder,HttpStatus.ACCEPTED);
	}
}
