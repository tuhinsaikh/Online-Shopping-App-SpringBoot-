package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.User;
import com.project.model.UserDTO;
import com.project.service.UserLoginService;
import com.project.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService uService;
	
	@Autowired
	private UserLoginService ulogService;
	
	@PostMapping("/regisrtration")
	public User saveUserController(@RequestBody User user) {
		return uService.saveUer(user);
	}
	
	@PostMapping("/login")
	public String userLoginController(@RequestBody UserDTO userDto) {
		//System.out.println(userDto);
		return ulogService.userLogin(userDto);
	}
	
}
