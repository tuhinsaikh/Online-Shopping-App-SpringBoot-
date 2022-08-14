package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Address;
import com.project.model.Customer;
import com.project.service.AddressService;
import com.project.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService cService;
//	private AddressService aService;
	
	@PostMapping("/")
	public Customer saveCustomerHandler(@RequestBody Customer customer) {
		
		return cService.addCustomer(customer);
	}
	
	
	@PutMapping("/")
	public Customer updateCustomer(@RequestBody Customer customer) {
		
		return cService.updateCustomer(customer);
	}
	
	@GetMapping("/{customerId}")
	public Customer getCustomer(@PathVariable Integer customerId) {
		
		return cService.viewCustomer(customerId);
		
	}
	
	
	@DeleteMapping("/")
	public Customer deleteCustomerDetails(@RequestBody Customer customer) {
		
		return cService.removeCustomer(customer);
		
	}
	
	
	
	
	
	
	
	

}
