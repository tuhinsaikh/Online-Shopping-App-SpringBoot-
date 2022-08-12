package com.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Customer;
import com.project.service.CustomerService;

@RestController("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService cService;
	
	
	@PostMapping("/")
	public Customer saveCustomer(@RequestBody Customer customer) {
		
		return cService.addCustomer(customer);
		
	}
	

}
