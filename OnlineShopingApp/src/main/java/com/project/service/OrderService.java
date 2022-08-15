package com.project.service;

import java.util.List;

import com.project.model.MyOrder;

public interface OrderService {

	public MyOrder addOrder(MyOrder order,Integer customerId,Integer addressId);

	public List<MyOrder>viewOrder();
	
	public MyOrder viewOrderByCustomerId(Integer custiomerId);
	
	public List<MyOrder>findOrderByUserName(String FirstName,String LastName);
	
	public MyOrder updateOrder(Integer custiomerId,MyOrder order);
	
	public MyOrder removeOrder(Integer custiomerId);
	
}
