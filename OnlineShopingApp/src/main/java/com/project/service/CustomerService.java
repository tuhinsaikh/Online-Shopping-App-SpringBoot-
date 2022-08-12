package com.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.exception.CustomerNotFoundException;
import com.project.model.Customer;

//@Service
public interface CustomerService {
	
	
	public Customer addCustomer(Customer customer) throws CustomerNotFoundException;
	
//	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException;
//	
//	public Customer removeCustomer(Customer customer) throws CustomerNotFoundException;
//	
//	public Customer viewCustomer(Customer customer) throws CustomerNotFoundException;
//	
//	public List<Customer> viewAllCustomerByLocation(String location) throws CustomerNotFoundException;
	

}
