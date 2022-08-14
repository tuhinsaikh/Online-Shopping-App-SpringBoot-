package com.project.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer catId;
	private String categoryName;
	
	//@ManyToMany(cascade = CascadeType.ALL)
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
	//@JsonIgnore
	private List<Product> products= new ArrayList<>();

	@Override
	public String toString() {
		return "Category [catId=" + catId + ", categoryName=" + categoryName + ", products=" + products + "]";
	}

	public Category(Integer catId, String categoryName, List<Product> products) {
		super();
		this.catId = catId;
		this.categoryName = categoryName;
		this.products = products;
	}
	
	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Integer getCatId() {
		return catId;
	}

	public void setCatId(Integer catId) {
		this.catId = catId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}
