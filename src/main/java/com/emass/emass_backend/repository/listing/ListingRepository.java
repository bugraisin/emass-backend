package com.emass.emass_backend.repository.listing;

import com.emass.emass_backend.model.entity.enums.ListingStatus;
import com.emass.emass_backend.model.entity.listing.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListingRepository extends JpaRepository<Listing, Long> {
    public List<Listing> findByOwnerId(Long id);
    List<Listing> findByStatus(ListingStatus status);

}
