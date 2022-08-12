package com.project.service;

import org.springframework.stereotype.Service;

import com.project.model.User;

@Service
public interface UserService {
	public User saveUer(User user);
}
