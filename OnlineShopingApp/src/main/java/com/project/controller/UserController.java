package com.project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public User saveUserController(@Valid @RequestBody User user) {
		return uService.saveUer(user);
	}
	
	@PostMapping("/login")
	public String userLoginController(@Valid @RequestBody UserDTO userDto) {
		return ulogService.userLogin(userDto);
	}
	
	@PutMapping("/updateUser/{key}")
	public User updateUserCredentialController(@Valid @RequestBody User user, @PathVariable String key) {
		return uService.updateUserCredential(user, key);
	}
	
	@PostMapping("/logout/{key}")
	public String userLogoutController(@Valid @PathVariable String key) {
		return uService.userLogout(key);
	}
	
}
