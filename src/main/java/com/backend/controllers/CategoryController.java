package com.backend.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.entity.Category;
import com.backend.service.CategoryService;

@RestController
@CrossOrigin("*")
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/add")
	public ResponseEntity<Category> createCategory(@RequestBody Category category){
		return ResponseEntity.ok(categoryService.addCategory(category));
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Category>> getCategories(){
		return ResponseEntity.ok(categoryService.getCategories());
	}
}
