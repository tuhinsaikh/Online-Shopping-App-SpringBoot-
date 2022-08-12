package com.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

@RestController
public class ServiceLayerOfOrder {

	@GetMapping("/order")
	public Order getOrder() {
		
		return null;
	}
}
