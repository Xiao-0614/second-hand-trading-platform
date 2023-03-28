package com.chloekarah.uploadservice;


import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import java.io.File;
import java.io.IOException;

public class s3Repository {

    private static final String S3_BUCKET_NAME = "my-bucket-name";

    public static String uploadFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        File localFile = File.createTempFile("temp", fileName);
        file.transferTo(localFile);
        String s3Key = "my-folder/" + fileName;

        AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();
        PutObjectRequest putRequest = new PutObjectRequest(S3_BUCKET_NAME, s3Key, localFile);
        s3Client.putObject(putRequest);

        localFile.delete();
        return "https://" + S3_BUCKET_NAME + ".s3.amazonaws.com/" + s3Key;
    }
}
