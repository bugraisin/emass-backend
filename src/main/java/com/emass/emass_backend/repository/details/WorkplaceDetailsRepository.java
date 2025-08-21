package com.emass.emass_backend.repository.details;

import com.emass.emass_backend.model.entity.details.WorkplaceDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkplaceDetailsRepository extends JpaRepository<WorkplaceDetails, Long> {
    Optional<WorkplaceDetails> findByListingId(Long id);
}
