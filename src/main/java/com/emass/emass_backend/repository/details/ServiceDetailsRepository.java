package com.emass.emass_backend.repository.details;

import com.emass.emass_backend.model.entity.listing.details.OfficeDetails;
import com.emass.emass_backend.model.entity.listing.details.ServiceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface ServiceDetailsRepository extends JpaRepository<ServiceDetails, Long>, JpaSpecificationExecutor<ServiceDetails> {
    Optional<ServiceDetails> findByListingId(Long id);
}
