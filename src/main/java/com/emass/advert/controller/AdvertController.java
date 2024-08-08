package com.emass.advert.controller;

import com.emass.advert.repository.AdvertEntity;
import com.emass.service.AdvertService;
import com.emass.user.repository.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/adverts")
public class AdvertController {

    @Autowired
    private AdvertService advertService;

    @PostMapping("/{userId}")
    public ResponseEntity<AdvertEntity> createAdvert(@PathVariable String userId, @RequestBody AdvertEntity advertEntity) {
        advertEntity.setUser(new UserEntity(userId));
        AdvertEntity createdAdvert = advertService.save(advertEntity);
        return ResponseEntity.ok(createdAdvert);
    }

    @PutMapping("/{userId}/{advertId}")
    public ResponseEntity<AdvertEntity> updateAdvert(@PathVariable String userId, @PathVariable String advertId, @RequestBody AdvertEntity updatedAdvert) {
        Optional<AdvertEntity> updated = advertService.updateAdvert(advertId, userId, updatedAdvert);
        return updated.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<AdvertEntity>> getUserAdverts(@PathVariable String userId) {
        List<AdvertEntity> adverts = advertService.getUserAdverts(userId);
        return ResponseEntity.ok(adverts);
    }

    @GetMapping("/")
    public ResponseEntity<List<AdvertEntity>> getAllAdverts() {
        List<AdvertEntity> adverts = advertService.findAll();
        return ResponseEntity.ok(adverts);
    }

    @GetMapping("/{advertId}")
    public ResponseEntity<AdvertEntity> getAdvertById(@PathVariable String advertId) {
        AdvertEntity advert = advertService.findById(advertId);
        return advert != null ? ResponseEntity.ok(advert) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{advertId}")
    public ResponseEntity<Void> deleteAdvert(@PathVariable String advertId) {
        advertService.deleteById(advertId);
        return ResponseEntity.noContent().build();
    }
}
