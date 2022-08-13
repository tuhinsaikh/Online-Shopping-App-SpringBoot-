package com.project.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.MyOrder;
import com.project.repository.OrderDao;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDao orderdao;

	@Override
	public MyOrder addorder(MyOrder order) {
		order.setLocaldtetime(LocalDateTime.now());
		return orderdao.save(order);
	}
}
