package com.emass.emass_backend.repository.listing;

import com.emass.emass_backend.model.entity.listing.ListingPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListingPhotoRepository extends JpaRepository<ListingPhoto, Long> {

    List<ListingPhoto> findByListingIdOrderByIdAsc(Long listingId);

    List<ListingPhoto> findByListingIdOrderBySeqNumberAsc(Long listingId);

    Integer countByListingId(Long listingId);
}