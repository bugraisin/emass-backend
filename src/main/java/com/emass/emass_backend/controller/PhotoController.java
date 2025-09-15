package com.emass.emass_backend.controller;

import com.emass.emass_backend.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/photos")
public class PhotoController {

    private final PhotoService photoService;

    @PostMapping("/{listingId}")
    @ResponseStatus(HttpStatus.OK)
    public void uploadPhotos(
            @PathVariable Long listingId,
            @RequestParam("photos") List<MultipartFile> photos) {

        photoService.uploadPhotos(listingId, photos);
    }
}
