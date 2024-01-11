package com.backend.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.entity.Category;
import com.backend.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

	public List<Product> findByCategory(Category category);
}
