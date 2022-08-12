package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exception.CustomerNotFoundException;
import com.project.model.Customer;
import com.project.repository.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao cDao;

	@Override
	public Customer addCustomer(Customer customer) throws CustomerNotFoundException{
		
		return cDao.save(customer);
	}

//	@Override
//	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException{
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Customer removeCustomer(Customer customer) throws CustomerNotFoundException{
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Customer viewCustomer(Customer customer) throws CustomerNotFoundException{
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Customer> viewAllCustomerByLocation(String location) throws CustomerNotFoundException{
//		// TODO Auto-generated method stub
//		return null;
//	}

}
