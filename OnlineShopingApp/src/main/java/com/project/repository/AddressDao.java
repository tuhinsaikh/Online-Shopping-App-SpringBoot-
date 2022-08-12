package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Address;

@Repository
public interface AddressDao extends JpaRepository<Address, Integer>{

}
