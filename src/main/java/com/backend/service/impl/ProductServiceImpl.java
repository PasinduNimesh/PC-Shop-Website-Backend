package com.backend.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.entity.Category;
import com.backend.entity.Product;
import com.backend.repo.ProductRepo;
import com.backend.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepo productRepo;
	
	@Override
	public Product addProduct(Product product) {
		return productRepo.save(product);
	}

	@Override
	public Set<Product> getPoducts() {
		return new HashSet<>(productRepo.findAll());
	}

	@Override
	public List<Product> getProductByCategory(Category category) {
		return productRepo.findByCategory(category);
	}

}
