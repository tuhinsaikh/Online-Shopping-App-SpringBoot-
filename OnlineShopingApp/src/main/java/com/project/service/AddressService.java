package com.project.service;

import java.util.List;

import com.project.model.Address;

public interface AddressService {
	
	public Address addAddress(Address add);
	public Address updateAddress(Address add);
	public Address removeAddress(Integer id);
	public Address viewAddress(Integer addressId);
	public List<Address> viewAllAddress();
	

}

