package com.project.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
import lombok.ToString;



@Data
@AllArgsConstructor
@NoArgsConstructor
=======
>>>>>>> ef463751665b900a1795e9e93ca81c455c6256a6
@Entity
public class Products {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	private String productName;
	private Double price;
	private String color; 
	private String dimension;
	private String specification;
	private String manufacturer;
	private Integer quantity;
	
	@Enumerated(EnumType.STRING)
	private CategoryEnum category;

<<<<<<< HEAD
=======

>>>>>>> ef463751665b900a1795e9e93ca81c455c6256a6
}
