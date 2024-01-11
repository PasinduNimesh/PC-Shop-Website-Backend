package com.backend.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.entity.Category;
import com.backend.repo.CategoryRepo;
import com.backend.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public Category addCategory(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public List<Category> getCategories() {
		return categoryRepo.findAll();
	}

}
