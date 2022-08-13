package com.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{
	
	public User findByMobile(String mobile);

//	public User findByUserId(Integer userId);
}
