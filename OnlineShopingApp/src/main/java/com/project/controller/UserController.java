package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.User;
import com.project.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService uService;
	
	@PostMapping("/regisrtration")
	public User saveUserController(@RequestBody User user) {
		return uService.saveUer(user);
	}
}
