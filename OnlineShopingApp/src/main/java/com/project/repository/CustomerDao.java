package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {

}
