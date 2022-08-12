package com.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{

	public Optional<User> findByMobile(String mobile);

}
