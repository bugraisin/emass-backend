package com.emass.emass_backend.controller;

import com.emass.emass_backend.model.dto.listing.ListingResponse;
import com.emass.emass_backend.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/favorites")
@RequiredArgsConstructor
@CrossOrigin("*")
public class FavoritesController {

    private final FavoriteService favoriteService;

    @PostMapping("/{listingId}")
    public void addToFavorites(@PathVariable Long listingId, @RequestBody Map<String, Long> request) {
        Long userId = request.get("userId");
        favoriteService.addToFavorites(listingId, userId);
    }

    @DeleteMapping("/{listingId}")
    public void removeFromFavorites(@PathVariable Long listingId, @RequestBody Map<String, Long> request) {
        Long userId = request.get("userId");
        favoriteService.removeFromFavorites(userId, listingId);
    }

    @GetMapping
    public List<ListingResponse> getUserFavorites(@RequestParam Long userId) {
        return favoriteService.getUserFavorites(userId);
    }

    @GetMapping("/count/{listingId}")
    public long getFavoriteCount(@PathVariable Long listingId) {
        return favoriteService.getFavoriteCount(listingId);
    }

    @GetMapping("/{listingId}/check")
    public boolean isFavorite(@PathVariable Long listingId, @RequestParam Long userId) {
        return favoriteService.isFavorite(userId, listingId);
    }
}
