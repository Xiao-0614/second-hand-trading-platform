package com.chloekarah.uploadservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Service
public class UploadService {

//	public static void main(String[] args) {
//		SpringApplication.run(UploadService.class, args);
//	}

	private UploadService uploadService;

	public String uploadFile(MultipartFile file) {
		try {
			return s3Repository.uploadFile(file);
		} catch (IOException e) {
			throw new RuntimeException("Failed to upload file to S3: " + e.getMessage());
		}
	}

}
