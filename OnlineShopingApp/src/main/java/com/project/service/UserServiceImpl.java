package com.project.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.project.exception.UserAlreadyExists;
import com.project.model.User;
import com.project.repository.UserDao;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao uDao;

	@Override
	public User saveUer(User user) {		
		User u = uDao.findByMobile(user.getMobile());
		if(u==null) return uDao.save(user);
		else throw new UserAlreadyExists("User Already Exists");
	}
}
