package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Customer;
import com.project.repository.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao cDao;
	

	@Override
	public Customer addCustomer(Customer customer) {
		
		return cDao.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer removeCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer viewCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> viewAllCustomerByLocation(String location) {
		// TODO Auto-generated method stub
		return null;
	}

}
