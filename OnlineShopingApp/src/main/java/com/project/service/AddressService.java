package com.project.service;

import com.project.model.Address;

public interface AddressService {
	
	public Address addAddress(Address add);
	public Address updateAddress(Address add);
	public Address removeAddress(Address add);
	public Address viewAllAddress(Integer addressId);
	public Address viewAddress(Address add);
	

}