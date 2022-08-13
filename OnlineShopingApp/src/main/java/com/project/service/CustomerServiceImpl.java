package com.project.service;

import java.util.List;
import java.util.Optional;

import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.OptBoolean;
import com.project.exception.CustomerNotFoundException;
import com.project.model.Address;
import com.project.model.Customer;
import com.project.repository.AddressDao;
import com.project.repository.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao cDao;
	
	@Autowired
	private AddressDao aDao;
	

	@Override
	public Customer addCustomer(Customer customer) {
		
		List<Address> addresses= customer.getAddresslist();
		
		if(addresses.size()!=0) {
			
			for(Address address:addresses) {
				
				aDao.save(address);
//				System.out.println(address);
				
			}
			
		}
		
		return cDao.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		
		Integer customerId= customer.getCustomerId();
		
		Optional<Customer> opt = cDao.findById(customerId);
		
		if(opt.isPresent()) {
			
			Customer optCustomer= opt.get();
			
			List<Address> addresses= optCustomer.getAddresslist();
			
			if(addresses.size()!=0) {
				
				for(Address address:addresses) {
					
//					Integer addressId= address.getAddressId();
					
					aDao.save(address);
					
				}
				
				
			}
			
			 return  cDao.save(customer);
		}
		else
			
			throw new CustomerNotFoundException("Invalid Customer input.");
	}

	@Override
	public Customer removeCustomer(Customer customer) {
		
		Integer customerId= customer.getCustomerId();
		
		Optional<Customer> opt = cDao.findById(customerId);
		
		if(opt.isPresent()) {
			
			Customer optCustomer= opt.get();
			
			   cDao.delete(optCustomer);
			   return customer;
		}
		else
			
			throw new CustomerNotFoundException("Invalid Customer input.");
		
	}


	@Override
	public Customer viewCustomer(Integer id) {
		
		Optional<Customer> opt=  cDao.findById(id);
		
		Customer optCustomer= opt.get();
		
		return optCustomer;
		
	}
	
	
	

	@Override
	public List<Customer> viewAllCustomerByLocation(String location) {
		
		
		
		
		return null;
	}

	
	

}
