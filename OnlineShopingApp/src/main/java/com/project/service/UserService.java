package com.project.service;

import com.project.model.User;

public interface UserService {
	
	public User saveUer(User user);
	
	public User updateUserCredential(User user,String key);
	
	public String userLogout(String key);
}
