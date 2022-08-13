package com.project.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exception.UserAlreadyExists;
import com.project.model.CurrentUserSession;
import com.project.model.User;
import com.project.model.UserDTO;
import com.project.repository.CurrentUserSessionDao;
import com.project.repository.UserDao;

import net.bytebuddy.utility.RandomString;

@Service
public class UserLoginServiceImpl implements UserLoginService{
	
	@Autowired
	private CurrentUserSessionDao currentusersessionDao;
	
	@Autowired
	private UserDao uDao;

	@Override
	public String userLogin(UserDTO userDto) {

		User u = uDao.findByMobile(userDto.getMobileNo());

		if(u==null) {
			return "Enter a valid mobile number";
		}
		Optional<CurrentUserSession> opt1 = currentusersessionDao.findById(u.getUserId());
		if(opt1.isPresent()) {
			throw new UserAlreadyExists("User Already loged in");
		}
		
		if(u.getPassword().equals(userDto.getPassword())) {
			String key = RandomString.make(6);
			CurrentUserSession currentUserSession = new CurrentUserSession(u.getUserId(), key,LocalDateTime.now());;
			currentusersessionDao.save(currentUserSession);
			return currentUserSession.toString();
			
		}else return "Password does not match";
	
	}

}
