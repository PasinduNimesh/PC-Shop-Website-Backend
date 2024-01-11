package com.backend.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.entity.ImageModel;

public interface ImageRepo extends JpaRepository<ImageModel, Long>{

	Optional<ImageModel> findByName(String name);
}
