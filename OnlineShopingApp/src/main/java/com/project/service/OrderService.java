package com.project.service;

import com.project.model.MyOrder;

public interface OrderService {

	public MyOrder addOrder(MyOrder order,Integer customerId,Integer addressId);

}
