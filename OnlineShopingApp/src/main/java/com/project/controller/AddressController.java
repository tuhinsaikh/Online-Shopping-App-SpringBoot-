package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Address;
import com.project.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService aService;
	
	@PostMapping("/")
	public ResponseEntity<Address> saveAddressHandler(@RequestBody Address add){
		Address savedAddress = aService.addAddress(add);
		return new ResponseEntity<Address>(savedAddress,HttpStatus.ACCEPTED);
	}

}
