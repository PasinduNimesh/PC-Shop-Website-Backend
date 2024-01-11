package com.backend.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.entity.Category;
import com.backend.entity.Product;
import com.backend.service.ProductService;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@PostMapping("/add")
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		return ResponseEntity.ok(productService.addProduct(product));
	}
	
	@GetMapping("/get")
	public ResponseEntity<?> getProducts(){
		return ResponseEntity.ok(productService.getPoducts());
	}
	
	@GetMapping("/get/{cid}")
	public ResponseEntity<?> getProductsByCategory(@PathVariable("cid") int cid){
		
		Category category = new Category();
		category.setId(cid);
		return ResponseEntity.ok(productService.getProductByCategory(category));
	}
}
