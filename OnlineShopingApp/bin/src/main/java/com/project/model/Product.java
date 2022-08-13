package com.project.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	private String productName;
	private Double price;
//	private String color; 
//	private String dimension;
//	private String specification;
//	private String manufacturer;
//	private Integer quantity;
	
	@ManyToMany(cascade = CascadeType.ALL ,mappedBy = "products")
	List<Category> categories= new ArrayList<>();

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
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

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + ", categories="
				+ categories + "]";
	}

	public Product(Integer productId, String productName, Double price, List<Category> categories) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.categories = categories;
	}
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
}
