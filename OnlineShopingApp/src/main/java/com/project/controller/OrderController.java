package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Address;
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
	
	@PostMapping("/addFromCart/{customerId}")
	public ResponseEntity<MyOrder>addOrderFromCart(@PathVariable Integer customerId){
		MyOrder myOrder=orderservice.addorderFromCart(customerId);
		return new ResponseEntity<MyOrder>(myOrder,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/findallOrder")
	public ResponseEntity<List<MyOrder>>viewAllOrder(){
		List<MyOrder>allOrder= orderservice.viewOrder();
		return new ResponseEntity<List<MyOrder>>(allOrder,HttpStatus.ACCEPTED);
	}

	@GetMapping("/findByCustomerId/{customerId}")
	public ResponseEntity<MyOrder>viewOrderByCustomerID(@PathVariable Integer customerId){
		MyOrder findOrder=orderservice.viewOrderByCustomerId(customerId);
		return new ResponseEntity<MyOrder>(findOrder,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/findOrderByUserName/{FirstName}/{LastName}")
	public ResponseEntity<List<MyOrder>>viewByUserName(@PathVariable("FirstName") String FirstName,@PathVariable("LastName") String LastName){
		List<MyOrder>getOrderByName= orderservice.findOrderByUserName(FirstName, LastName);
		return new ResponseEntity<List<MyOrder>>(getOrderByName,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("removeOrder/{customerId}")
	public ResponseEntity<MyOrder>removeOrderByCustomerID(@PathVariable Integer customerId){
		MyOrder findOrder=orderservice.removeOrder(customerId);
		
		return new ResponseEntity<MyOrder>(findOrder,HttpStatus.ACCEPTED);
	}
}
