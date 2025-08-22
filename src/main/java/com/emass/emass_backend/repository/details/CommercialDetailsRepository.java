package com.emass.emass_backend.repository.details;

import com.emass.emass_backend.model.entity.listing.details.CommercialDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommercialDetailsRepository extends JpaRepository<CommercialDetails, Integer> {
    Optional<CommercialDetails> findByListingId(Long id);
}
