package com.emass.emass_backend.repository.details;

import com.emass.emass_backend.model.entity.listing.details.OfficeDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OfficeDetailsRepository extends JpaRepository<OfficeDetails, Long> {
    Optional<OfficeDetails> findByListingId(Long id);
}
