package com.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressId;
	@NotNull(message = "please fill sreeet number")
	private String streetNo;
	@NotNull(message = "please fill Building name")
	private String buildingName;
	@NotNull(message = "please fill City name")
	private String city;
	@NotNull(message = "please fill state name")
	private String state;
	@NotNull(message = "please fill country name")
	private String country;
	@Pattern(regexp = "([1-9]{1}[0-9]{5}|[1-9]{1}[0-9]{3}\\\\s[0-9]{3})",message = "please input a valid pincode")
	private String pincode;
	

}
