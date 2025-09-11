package com.emass.emass_backend.repository.listing;

import com.emass.emass_backend.model.entity.listing.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorites, Long> {
    Optional<Favorites> findByUserIdAndListingId(Long userId, Long listingId);
    List<Favorites> findByUserId(Long userId);
    void deleteByUserIdAndListingId(Long userId, Long listingId);
    long countByUserIdAndListingId(Long userId, Long listingId);
    long countByListingId(Long listingId);
}
