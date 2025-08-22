package com.emass.emass_backend.repository.details;

import com.emass.emass_backend.model.entity.listing.details.HousingDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HousingDetailsRepository extends JpaRepository<HousingDetails, Long> {
    Optional<HousingDetails> findByListingId(Long id);
}
