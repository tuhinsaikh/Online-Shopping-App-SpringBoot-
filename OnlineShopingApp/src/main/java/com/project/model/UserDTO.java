package com.project.model;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO {
	
	@NotNull(message = "Enter Your Mobile Number")
	private String mobileNo;
	@NotNull(message = "Enter Your Password")
	private String password;
	
}
