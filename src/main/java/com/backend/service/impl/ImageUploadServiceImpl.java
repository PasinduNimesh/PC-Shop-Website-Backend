package com.backend.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.backend.entity.ImageModel;
import com.backend.repo.ImageRepo;
import com.backend.service.ImageUploadService;

@Service
public class ImageUploadServiceImpl implements ImageUploadService{
	
	@Autowired
	private ImageRepo repo;

//	@Override
//	public BodyBuilder saveImage(MultipartFile file) throws IOException {
//		System.out.println("Original Image Byte Size - " + file.getBytes().length);
//		ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(),
//				compressBytes(file.getBytes()));
//		repo.save(img);
//		return ResponseEntity.status(HttpStatus.OK);
//	}
	
	@Override
	public BodyBuilder saveImage(MultipartFile file) throws IOException {
		//System.out.println("Original Image Byte Size - " + file.getBytes().length);
		ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(),
				file.getBytes());
		repo.save(img);
		return ResponseEntity.status(HttpStatus.OK);
	}

//	@Override
//	public ImageModel retrieveImage(String imageName) {
//		final Optional<ImageModel> retrievedImage = repo.findByName(imageName);
//		ImageModel img = new ImageModel(retrievedImage.get().getId(), retrievedImage.get().getName(), retrievedImage.get().getType(),
//				decompressBytes(retrievedImage.get().getPicByte()));
//		return img;
//	}
	
	@Override
	public ImageModel retrieveImage(String imageName) {
		final Optional<ImageModel> retrievedImage = repo.findByName(imageName);
		ImageModel img = new ImageModel(retrievedImage.get().getId(), retrievedImage.get().getName(), retrievedImage.get().getType(),
				retrievedImage.get().getPicByte());
		return img;
	}
	
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
		return outputStream.toByteArray();
	}
	
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}

	@Override
	public List<ImageModel> getImages() {
		List<ImageModel> images = repo.findAll();
		return images;
	}


}
