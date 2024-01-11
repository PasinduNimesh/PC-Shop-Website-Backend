package com.backend.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.backend.entity.ImageModel;

public interface ImageUploadService {

	public BodyBuilder saveImage(@RequestParam("imageFile") MultipartFile file) throws IOException;
	public ImageModel retrieveImage(@PathVariable("imageName") String imageName) throws IOException;
	public List<ImageModel> getImages();
}
