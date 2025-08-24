package com.emass.emass_backend.repository.details;

import com.emass.emass_backend.model.entity.listing.details.HousingDetails;
import com.emass.emass_backend.model.entity.listing.details.OfficeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface OfficeDetailsRepository extends JpaRepository<OfficeDetails, Long>, JpaSpecificationExecutor<OfficeDetails> {
    Optional<OfficeDetails> findByListingId(Long id);
}
