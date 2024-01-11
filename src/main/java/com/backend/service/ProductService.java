package com.backend.service;

import java.util.List;
import java.util.Set;

import com.backend.entity.Category;
import com.backend.entity.Product;

public interface ProductService {

	public Product addProduct(Product product);
	public Set<Product> getPoducts();
	public List<Product> getProductByCategory(Category category);
}
