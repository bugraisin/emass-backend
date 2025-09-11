package com.emass.emass_backend.service;

import com.emass.emass_backend.model.entity.listing.Listing;
import com.emass.emass_backend.model.entity.listing.ListingPhoto;
import com.emass.emass_backend.repository.listing.ListingPhotoRepository;
import com.emass.emass_backend.repository.listing.ListingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PhotoService {

    private final ListingPhotoRepository listingPhotoRepository;
    private final ListingRepository listingRepository;
    private final S3Service s3Service;

    public void uploadPhotos(Long listingId, List<MultipartFile> photos) {
        Listing listing = listingRepository.findById(listingId)
                .orElseThrow(() -> new RuntimeException("Listing bulunamadı: " + listingId));

        for (int i = 0; i < photos.size(); i++) {
            MultipartFile file = photos.get(i);
            if (file != null && !file.isEmpty()) {
                try {
                    String fileName = UUID.randomUUID() + "-" + file.getOriginalFilename();
                    BufferedImage originalImage = ImageIO.read(file.getInputStream());

                    if (i == 0) {
                        BufferedImage thumbnail = resizeImage(originalImage, 300);
                        String thumbnailKey = "listings/thumb/" + fileName;
                        uploadBufferedImageToS3(thumbnail, thumbnailKey);
                        listing.setThumbnailUrl(s3Service.getFileUrl(thumbnailKey));
                        listingRepository.save(listing);
                    }

                    BufferedImage fullImage = resizeImage(originalImage, 1200);
                    String fullImageKey = "listings/full/" + fileName;
                    uploadBufferedImageToS3(fullImage, fullImageKey);

                    ListingPhoto photo = ListingPhoto.builder()
                            .listingId(listingId)
                            .fullImageUrl(s3Service.getFileUrl(fullImageKey))
                            .seqNumber(i + 1)
                            .build();

                    listingPhotoRepository.save(photo);

                } catch (Exception e) {
                    throw new RuntimeException("Fotoğraf yüklenemedi: " + e.getMessage());
                }
            }
        }
    }

    private BufferedImage resizeImage(BufferedImage original, int maxSize) {
        int width = original.getWidth();
        int height = original.getHeight();

        if (width <= maxSize && height <= maxSize) {
            return original;
        }

        if (width > height) {
            height = (height * maxSize) / width;
            width = maxSize;
        } else {
            width = (width * maxSize) / height;
            height = maxSize;
        }

        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(original, 0, 0, width, height, null);
        g2d.dispose();

        return resized;
    }

    private void uploadBufferedImageToS3(BufferedImage image, String key) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", baos);
        byte[] imageBytes = baos.toByteArray();
        s3Service.uploadBytes(key, imageBytes, "image/jpeg");
    }
}