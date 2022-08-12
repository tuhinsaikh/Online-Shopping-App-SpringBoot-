package com.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.model.Customer;

@Service
public interface CustomerService {
	
	
	public Customer addCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer);
	
	public Customer removeCustomer(Customer customer);
	
	public Customer viewCustomer(Customer customer);
	
	public List<Customer> viewAllCustomerByLocation(String location);
	

}
