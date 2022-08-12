package com.project.service;

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
	public Address removeAddress(Address add) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address viewAllAddress(Integer addressId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address viewAddress(Address add) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
