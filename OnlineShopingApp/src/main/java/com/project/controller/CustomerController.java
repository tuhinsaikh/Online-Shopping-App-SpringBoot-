package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Address;
import com.project.model.Customer;
import com.project.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService cService;
	
	@PostMapping("/customerSave")
	public Customer saveCustomerHandler(@RequestBody Customer customer) {
		System.out.println(customer);
		
		List<Address> alist=customer.getAddresslist();
		System.out.println(alist);
		if(alist!=null)
		{
			for(Address a:alist)
			{
				customer.getAddresslist().add(a);
			}
		}
		
		return cService.addCustomer(customer);
	}
	

}
