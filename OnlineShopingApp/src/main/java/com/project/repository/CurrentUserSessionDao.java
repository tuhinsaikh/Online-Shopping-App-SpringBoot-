package com.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.CurrentUserSession;

public interface CurrentUserSessionDao extends JpaRepository<CurrentUserSession, Integer>{
   public Optional<CurrentUserSession> findById(Integer userId);
}
