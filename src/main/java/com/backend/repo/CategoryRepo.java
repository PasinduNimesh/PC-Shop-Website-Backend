package com.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
