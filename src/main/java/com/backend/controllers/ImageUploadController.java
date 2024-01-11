package com.backend.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.backend.entity.ImageModel;
import com.backend.entity.Product;
import com.backend.service.ImageUploadService;

@RestController
@CrossOrigin("*")
@RequestMapping("/image")
public class ImageUploadController {

	@Autowired
	private ImageUploadService uploadService;
	
	@PostMapping("/upload")
	public BodyBuilder uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		return uploadService.saveImage(file);
	}
	
	@GetMapping(path = { "/get/{imageName}" })
	public ImageModel getImage(@PathVariable("imageName") String imageName) throws IOException {
		return uploadService.retrieveImage(imageName);
	}
	
	@GetMapping(path = "/get")
	public List<ImageModel> getImages(){
		return uploadService.getImages();
	}
	
	
}
