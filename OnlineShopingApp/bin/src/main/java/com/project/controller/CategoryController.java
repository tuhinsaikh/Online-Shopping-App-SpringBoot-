package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Category;
import com.project.service.CategoryService;

@RestController
public class CategoryController {
	
	
	@Autowired
	private CategoryService cService;
	
	
	@PostMapping("/savecategory")
	public Category saveCategoryHandler(@RequestBody Category category) {
		
		return cService.addCategory(category);
		
	}
	
}
