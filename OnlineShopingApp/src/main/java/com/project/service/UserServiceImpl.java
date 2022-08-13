package com.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exception.OrderNotfoundException;
import com.project.model.User;
import com.project.repository.UserDao;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao uDao;

	@Override
	public User saveUer(User user) {
		 Optional<User> opt = uDao.findByMobile(user.getMobile());
		 System.out.println(opt);
		 if(opt.isPresent()) {
			 throw new OrderNotfoundException("pagol valo kore de");
		 }else
		    return uDao.save(user);
	}
}
