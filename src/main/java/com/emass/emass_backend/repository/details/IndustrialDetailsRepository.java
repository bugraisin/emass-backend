package com.emass.emass_backend.repository.details;

import com.emass.emass_backend.model.entity.listing.details.CommercialDetails;
import com.emass.emass_backend.model.entity.listing.details.IndustrialDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface IndustrialDetailsRepository extends JpaRepository<IndustrialDetails, Integer>, JpaSpecificationExecutor<IndustrialDetails> {
    Optional<IndustrialDetails> findByListingId(Long id);
}
