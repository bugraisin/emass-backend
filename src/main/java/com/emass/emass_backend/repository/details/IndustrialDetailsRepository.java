package com.emass.emass_backend.repository.details;

import com.emass.emass_backend.model.entity.listing.details.IndustrialDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IndustrialDetailsRepository extends JpaRepository<IndustrialDetails, Integer> {
    Optional<IndustrialDetails> findByListingId(Long id);
}
