package com.backend.service;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.backend.entity.Category;

public interface CategoryService {

	public Category addCategory(Category category);
	public List<Category> getCategories();
}
