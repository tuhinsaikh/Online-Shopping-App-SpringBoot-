package com.project.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exception.CustomerNotFoundException;
import com.project.exception.UserAlreadyExists;
import com.project.model.Address;
import com.project.model.Customer;
import com.project.model.User;
import com.project.repository.AddressDao;
import com.project.repository.CurrentUserSessionDao;
import com.project.repository.CustomerDao;
import com.project.repository.UserDao;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao cDao;
	
	@Autowired
	private AddressDao aDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CurrentUserSessionDao userSessionDao;
	

	@Override
	public Customer addCustomer(Customer customer) {
		
		List<Address> addresses= customer.getAddresslist();
		
		String mobile= customer.getMobileNumber();
		
			User user=  userDao.findByMobile(mobile);
			Customer customerIspresent = cDao.findByMobileNumber(customer.getMobileNumber());
			if(customerIspresent!=null) throw new UserAlreadyExists("already present with this mobile number");
			if(user!=null) {
				Integer user_Id= user.getUserId();
				
				String currentUserId= userSessionDao.findByUserId(user_Id);
				if(currentUserId!=null) {
					Integer id= Integer.parseInt(currentUserId);				
					System.out.println(id);
					if(addresses.size()!=0) {				
						for(Address address:addresses) {				
								aDao.save(address);
								System.out.println(address);						
						}					
					}				
					return cDao.save(customer);	
				}
				else {
					throw new CustomerNotFoundException("Please login");
				}	
			}
			else
				throw new CustomerNotFoundException("Please login");
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		
		Integer customerId= customer.getCustomerId();
		
		Optional<Customer> opt = cDao.findById(customerId);
		
		Customer customerIspresent = cDao.findByMobileNumber(customer.getMobileNumber());
//		if(customerIspresent==null) throw new UserAlreadyExists("already present with this mobile number");
		if(customerIspresent!=null) {
			if(opt.isPresent()) {
				
				Customer optCustomer= opt.get();
				List<Address> addresses= optCustomer.getAddresslist();
				if(addresses.size()!=0) {
					for(Address address:addresses) {
//						Integer addressId= address.getAddressId();
						aDao.save(address);
					}
				}
				 return  cDao.save(customer);
			}
			else
				throw new CustomerNotFoundException("Invalid Customer input.");
		}
		else
			throw new CustomerNotFoundException("You Can't change Registered Mobile Number");
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
		
		Set<Customer> customers= new HashSet<>(); 
		
		List<Address> addresses= aDao.findByCity(location);
		
		if(addresses.size()>0) {
			
			
			
		}
		
		return null;
	}

	@Override
	public Address addAddress(Address address) {
		return	aDao.save(address);
		 
	}

	
	

}
