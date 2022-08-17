package com.project.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import com.project.exception.AddressNotFound;
import com.project.exception.CustomerNotFoundException;
import com.project.model.Address;
import com.project.model.Cart;
import com.project.model.CurrentUserSession;
import com.project.model.Customer;
import com.project.model.MyOrder;
import com.project.model.Products;
import com.project.model.User;
import com.project.repository.AddressDao;
import com.project.repository.CartDao;
import com.project.repository.CurrentUserSessionDao;
import com.project.repository.CustomerDao;
import com.project.repository.OrderDao;
import com.project.repository.ProductsDao;

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
	private	ProductsDao productDao;
	
	@Autowired
	private AddressDao addressDao;
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private CartServiceImpl cartServiceImpl;
	
	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	
	@Autowired
	 private CartService cartService;

	//parameter customerId,addressId
//	@Override
//	public MyOrder addOrder(MyOrder order, Integer customerId, Integer addressId) {
//		
//		order.setLocaldtetime(LocalDateTime.now());
//		order.setOrderstatus("accepted");
//		Optional< Customer> databaseCustomer = customerDao.findById(customerId);
//		
//		if(databaseCustomer.isEmpty()) {
//			throw new CustomerNotFoundException("customer not found");
//		}
//		Customer customer = databaseCustomer.get();
//		User user=  userDao.findByMobile(databaseCustomer.get().getMobileNumber());
//		String logedinOrNot = currUserSessDao.findByUserId(user.getUserId());
//		if(logedinOrNot==null) {
//			throw new CustomerNotFoundException("Customer not logged in");
//		}
//		
//		List<Products> products = order.getProductlist();
//		List<Products> products2=new ArrayList<Products>();
//		for(Products p:products) {
//			
//			List<Products> pr = productDao.findByProductName(p.getProductName());
//			if(pr.size()<=0) {
//			
//				throw new CustomerNotFoundException("Product not found");
//			}
////			System.out.println(pr);
//			for(Products prd:pr) {
//				if(prd.getPrice().equals(p.getPrice())) {
//					products2.add(prd);
//				}
//				
//			}
//			
//			
//		}
//	
//		 order.setProductlist(products2);
//		
//		List<Address> customerAddr = customer.getAddresslist();
//		int count = 0;
//		for(Address addr: customerAddr) {
//			if(addr.getAddressId()==addressId) {
//				order.setAddress(addr);
//			}else count++;
//		}
//		if(count==customerAddr.size()) throw new AddressNotFound("Address not found with the customer Id"+customerId);
//		order.setCustomer(customer);	
//		return orderdao.save(order);
//	}

	@Override
	public List<MyOrder> viewOrder() {
		List<MyOrder>allOrder=orderdao.findAll();
		return allOrder;
	}

	@Override
	public MyOrder viewOrderByCustomerId(Integer custiomerId) {
		List<MyOrder>allOrder=orderdao.findAll();
		
		for(MyOrder order:allOrder) {
			if(order.getCustomer().getCustomerId()==custiomerId) {
			return order;
			}
		}
		throw new CustomerNotFoundException("Order not found");
	}

	@Override
	public List<MyOrder> findOrderByUserName(String FirstName, String LastName,String mobileNo) {
		List<MyOrder>allOrder=orderdao.findAll();
		List<MyOrder>findAllByName=new ArrayList<MyOrder>();
		for(MyOrder order:allOrder) {
			if(order.getCustomer().getFirstName().equals(FirstName)&& order.getCustomer().getLastName().equals(LastName)&&order.getCustomer().getMobileNumber().equals(mobileNo) ) {
			findAllByName.add(order);
			}
			
		}
//		System.out.println(findAllByName);
		if(findAllByName.size()==0) {
			throw new CustomerNotFoundException("Order not found");
		}else {
			return findAllByName;
		}
	}

	@Override
	public MyOrder updateOrder(Integer custiomerId, MyOrder order) {
		List<MyOrder>allOrder=orderdao.findAll();
		int count=0;
		MyOrder findord=new MyOrder();
		for(MyOrder find:allOrder) {
			if(find.getCustomer().getCustomerId()==custiomerId) {
				findord=find;
				count++;
			}

		}
		if(count==0) {
			throw new CustomerNotFoundException("Order not found");
		}
	
		
		
		List<Products> products2=order.getProductlist();
		List<Products> products = findord.getProductlist();
		return findord;
		
		
	}

	@Override
	public String removeOrder(Integer custiomerId) {
		
		List<MyOrder>allOrder=orderdao.findAll();
		
		
		for(MyOrder order:allOrder) {
			if(order.getCustomer().getCustomerId()==custiomerId) {
//			 orderdao.delete(order);
				
				User user=  userDao.findByMobile(order.getCustomer().getMobileNumber());
				String logedinOrNot = currUserSessDao.findByUserId(user.getUserId());
				if(logedinOrNot==null) {
					throw new CustomerNotFoundException("Customer not logged in");
				}
				order.setCustomer(null);
				order.setProductlist(null);
				orderdao.save(order);
				System.out.println(order);
				orderdao.delete(order);
				
			 return "order canceled";
			}
		}
		
		throw new CustomerNotFoundException("Order not found");
	}

	@Override
	public MyOrder addorderFromCart(Integer customerId) {
		// TODO Auto-generated method stub
		
		MyOrder myOrder=new MyOrder();
		Cart cart=new Cart();
		List<Cart> allCartDetails=cartServiceImpl.ViewAllCart();
		List<Products>getProducts=new ArrayList<>();
		
		for(Cart newCart:allCartDetails) {
			if(newCart.getCustomerlist().getCustomerId()==(customerId)) {
				getProducts.add(newCart.getCartItem());
				allCartDetails.remove(newCart.getCartItem());
			}
			
		}
		System.out.println(getProducts);
		myOrder.setLocaldtetime(LocalDateTime.now());
		myOrder.setOrderstatus("ORDER PLACED");
		
		Optional<Customer>opt=customerDao.findById(customerId);
		
		if(opt.isEmpty()) {
			throw new CustomerNotFoundException("Customer not found with this Id"+customerId);
		}
		myOrder.setCustomer(opt.get());
		myOrder.setProductlist(getProducts);

		MyOrder myOrder2= orderdao.save(myOrder);
//		cartService.deleteAllCart();
		
		return myOrder2;
	}


	
}






















