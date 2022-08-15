package com.project.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.project.exception.UserAlreadyExists;
import com.project.model.CurrentUserSession;
import com.project.model.User;
import com.project.repository.CurrentUserSessionDao;
import com.project.repository.UserDao;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao uDao;
	
	@Autowired
	private CurrentUserSessionDao cuserDao;

	@Override
	public User saveUer(User user) {		
		User u = uDao.findByMobile(user.getMobile());
		if(u==null) return uDao.save(user);
		else throw new UserAlreadyExists("User Already Exists");
	}

	@Override
	public User updateUserCredential(User user, String key) {
		CurrentUserSession cuser =  cuserDao.findByUniqueId(key);
		if(cuser==null) throw new UserAlreadyExists("user not loged in");
		Optional<User> opt = uDao.findById(cuser.getUserId());
		if(opt.isEmpty()) throw new UserAlreadyExists("user not found");
		User userWithSameNumber = uDao.findByMobile(user.getMobile());
		if(userWithSameNumber!=null) throw new UserAlreadyExists("one user find with the same mobile number");
		User saveUser = uDao.save(user);
		cuserDao.delete(cuser);
		uDao.delete(opt.get());
		return saveUser;
	}

	@Override
	public String userLogout(String key) {
		CurrentUserSession cuser =  cuserDao.findByUniqueId(key);
		if(cuser==null) throw new UserAlreadyExists("user not loged in");
		cuserDao.delete(cuser);
		return "Logged Out successfully";
	}


	
}
