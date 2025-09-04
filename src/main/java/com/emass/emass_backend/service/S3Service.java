package com.emass.emass_backend.service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class S3Service {

    @Value("${aws.access.key}")
    private String accessKey;

    @Value("${aws.secret.key}")
    private String secretKey;

    @Value("${aws.region}")
    private String region;

    @Value("${aws.s3.bucket}")
    private String bucketName;

    private AmazonS3 amazonS3Client;

    private AmazonS3 getS3Client() {
        if (amazonS3Client == null) {
            BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKey, secretKey);
            amazonS3Client = AmazonS3ClientBuilder.standard()
                    .withRegion(Regions.fromName(region))
                    .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                    .build();
        }
        return amazonS3Client;
    }

    // Fotoğraf yükleme
    public String uploadPhoto(MultipartFile file) {
        try {
            String fileName = "listings/" + UUID.randomUUID() + "-" + file.getOriginalFilename();

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(file.getSize());
            metadata.setContentType(file.getContentType());

            getS3Client().putObject(bucketName, fileName, file.getInputStream(), metadata);
            return getS3Client().getUrl(bucketName, fileName).toString();

        } catch (IOException e) {
            throw new RuntimeException("Fotoğraf yüklenemedi: " + e.getMessage());
        }
    }

    // Byte array yükleme (thumbnail için)
    public String uploadBytes(String key, byte[] data, String contentType) {
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(data.length);
        metadata.setContentType(contentType);

        getS3Client().putObject(bucketName, key, new ByteArrayInputStream(data), metadata);
        return getS3Client().getUrl(bucketName, key).toString();
    }

    // Bucket'taki tüm dosyaları listele
    public List<String> listAllFiles() {
        return getS3Client().listObjectsV2(bucketName)
                .getObjectSummaries()
                .stream()
                .map(S3ObjectSummary::getKey)
                .collect(Collectors.toList());
    }

    // Dosya sil
    public boolean deleteFile(String fileName) {
        try {
            getS3Client().deleteObject(bucketName, fileName);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Dosya URL'si al
    public String getFileUrl(String key) {
        return getS3Client().getUrl(bucketName, key).toString();
    }
}