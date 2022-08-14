package com.project.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exception.AddressNotFound;
import com.project.exception.CustomerNotFoundException;
import com.project.model.Address;
import com.project.model.CurrentUserSession;
import com.project.model.Customer;
import com.project.model.MyOrder;
import com.project.model.Product;
import com.project.model.User;
import com.project.repository.AddressDao;
import com.project.repository.CurrentUserSessionDao;
import com.project.repository.CustomerDao;
import com.project.repository.OrderDao;
import com.project.repository.ProductDao;
import com.project.repository.UserDao;



@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDao orderdao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CurrentUserSessionDao currUserSessDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private AddressDao addressDao;

	//parameter customerId,addressId
	@Override
	public MyOrder addOrder(MyOrder order, Integer customerId, Integer addressId) {
		Optional< Customer> databaseCustomer = customerDao.findById(customerId);
		
		if(databaseCustomer.isEmpty()) {
			throw new CustomerNotFoundException("customer not found");
		}
		Customer customer = databaseCustomer.get();
		User user=  userDao.findByMobile(databaseCustomer.get().getMobileNumber());
		String logedinOrNot = currUserSessDao.findByUserId(user.getUserId());
		if(logedinOrNot==null) {
			throw new CustomerNotFoundException("Customer not logged in");
		}
		
		List<Product> products = order.getProductlist();
		
		for(Product p:products) {
			
			List<Product> pr = productDao.findByProductName(p.getProductName());
			if(pr.size()<=0) {
				throw new CustomerNotFoundException("Product not found");
			}
		}
		
		List<Address> customerAddr = customer.getAddresslist();
		int count = 0;
		for(Address addr: customerAddr) {
			if(addr.getAddressId()==addressId) {
				order.setAddress(addr);
			}else count++;
		}
		if(count==customerAddr.size()) throw new AddressNotFound("Address not found with the customer Id"+customerId);
		order.setCustomer(customer);	
		return orderdao.save(order);
	}

	
}





















