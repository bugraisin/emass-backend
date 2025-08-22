package com.emass.emass_backend.repository.details;

import com.emass.emass_backend.model.entity.listing.details.ServiceDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceDetailsRepository extends JpaRepository<ServiceDetails, Long> {
    Optional<ServiceDetails> findByListingId(Long id);
}
