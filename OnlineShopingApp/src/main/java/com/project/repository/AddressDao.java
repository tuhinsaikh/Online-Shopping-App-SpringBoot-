package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Address;


@Repository
public interface AddressDao extends JpaRepository<Address, Integer>{
	
	public Address findByaddressId(Integer addressId);
	
	public List<Address> findByCity(String city);
	
	

}
