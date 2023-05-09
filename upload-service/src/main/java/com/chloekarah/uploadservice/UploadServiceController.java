package com.chloekarah.uploadservice;

//import com.chloekarah.second-hand-platform.dto.Image;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/s3")
public class UploadServiceController {


    private final UploadService uploadService;

    public UploadServiceController(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam(value = "file") MultipartFile file) {
        return uploadService.uploadFile(file);
    }
}

