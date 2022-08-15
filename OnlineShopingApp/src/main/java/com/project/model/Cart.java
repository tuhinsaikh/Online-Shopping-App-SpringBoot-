package com.project.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartItemId;	
	
	
//	@OneToMany(cascade = CascadeType.ALL)
	@OneToOne
	private Products cartItem;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JsonIgnore
//	private Customer customer;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "ADDRESS_ID", referencedColumnName = "addressId")
	@OneToOne
	private Customer customerlist;
	
//	private Double cartTotal;
	



//	public Customer getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}

	

	
	

	
}
