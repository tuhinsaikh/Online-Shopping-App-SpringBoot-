package com.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.model.Address;
import com.project.model.Customer;

public interface CustomerService {
	
	
	public Customer addCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer);
	
	public Customer removeCustomer(Customer customer);
	
	public Customer viewCustomer(Integer id);
	
	public List<Customer> viewAllCustomerByLocation(String location);
	
	public Customer addAddress(Address address,Integer customerId);

}
