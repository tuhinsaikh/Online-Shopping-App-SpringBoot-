package com.project.service;

import java.util.List;

import com.project.model.Address;
import com.project.model.MyOrder;

public interface OrderService {

//	public MyOrder addOrder(MyOrder order,Integer customerId,Integer addressId);

	public List<MyOrder>viewOrder();
	
	public MyOrder viewOrderByCustomerId(Integer custiomerId);
	
	public List<MyOrder>findOrderByUserName(String FirstName,String LastName,String mobileNo);
	
	public MyOrder updateOrder(Integer custiomerId,MyOrder order);
	
	public String removeOrder(Integer custiomerId);
	
	public MyOrder addorderFromCart(Integer customerId);
	
}
