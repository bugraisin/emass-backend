package com.emass.emass_backend.service;

import com.emass.emass_backend.model.dto.listing.ListingResponse;
import com.emass.emass_backend.model.entity.User;
import com.emass.emass_backend.model.entity.listing.Favorites;
import com.emass.emass_backend.model.entity.listing.Listing;
import com.emass.emass_backend.repository.FavoritesRepository;
import com.emass.emass_backend.repository.ListingRepository;
import com.emass.emass_backend.repository.UserRepository;
import com.emass.emass_backend.service.mapper.ListingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoriteService {

    private final FavoritesRepository favoritesRepository;
    private final ListingRepository listingRepository;
    private final UserRepository userRepository;
    private final ListingMapper listingMapper;


    public void addToFavorites(Long listingId, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Listing listing = listingRepository.findById(listingId)
                .orElseThrow(() -> new RuntimeException("Listing not found"));

        if(favoritesRepository.findByUserIdAndListingId(userId, listingId).isPresent()) {
            throw new RuntimeException("Favorites already exists");
        }

        Favorites favorites = Favorites.builder()
                .user(user)
                .listing(listing)
                .build();

        favoritesRepository.save(favorites);
    }

    @Transactional
    public void removeFromFavorites(Long userId, Long listingId) {
        Favorites favorite = favoritesRepository.findByUserIdAndListingId(userId, listingId)
                .orElseThrow(() -> new IllegalArgumentException("Favorite not found"));

        favoritesRepository.delete(favorite);
    }


    public List<ListingResponse> getUserFavorites(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new IllegalArgumentException("User not found: " + userId);
        }

        List<Favorites> favorites = favoritesRepository.findByUserId(userId);

        return favorites.stream()
                .map(favorite -> listingMapper.toSearchResponse(favorite.getListing()))
                .toList();
    }

    public long getFavoriteCount(Long listingId) {
        return favoritesRepository.countByListingId(listingId);
    }

    @Transactional(readOnly = true)
    public boolean isFavorite(Long userId, Long listingId) {
        return favoritesRepository.findByUserIdAndListingId(userId, listingId).isPresent();
    }
}
