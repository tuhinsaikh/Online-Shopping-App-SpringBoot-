package com.project.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ProductsDTO {
	
	@NotNull(message = "please input a valid product name")
	@Pattern(regexp = "(?i)(^[a-z]+)[a-z .,-]((?! .,-)$){1,25}$",message = "please input a valid product name")
	private String productName;
	@NotNull(message = "please input a valid product name")
	private Double price;
	
	public ProductsDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProductsDTO(String productName, Double price) {
		super();
		this.productName = productName;
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductsDTO [productName=" + productName + ", price=" + price + "]";
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
