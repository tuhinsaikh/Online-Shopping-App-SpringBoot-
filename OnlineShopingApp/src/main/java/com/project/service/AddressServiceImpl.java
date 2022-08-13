package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exception.AddressNotFound;
import com.project.model.Address;
import com.project.repository.AddressDao;


@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	private AddressDao aDao;
	
	@Override
	public Address addAddress(Address add) {
		return aDao.save(add);
	}

	@Override
	public Address updateAddress(Address add) {
		
		Address a = aDao.findByaddressId(add.getAddressId());
		
		if(a!=null) {
			return aDao.save(add);
			
		}
		else {
			throw new AddressNotFound("No address exists");
		}
		
	}

	@Override
	public Address removeAddress(Integer id) {
		
		Address a = aDao.findByaddressId(id);
		
		if(a!=null) {
			aDao.delete(a);
			return a;
		}
		else {
			throw new AddressNotFound("No address exists");
		}
	}

	@Override
	public Address viewAddress(Integer addressId) {
		Address a = aDao.findByaddressId(addressId);
		
		if(a!=null) {
			return a;
		}
		else
		{
			throw new AddressNotFound("No address exists");
		}
	}

	@Override
	public List<Address> viewAllAddress(){
		List<Address> alist=aDao.findAll();
		if(alist!=null) {
			return alist;
		}
		else
		{
			throw new AddressNotFound("No address exists");
		}
		
	}
	
	

}
