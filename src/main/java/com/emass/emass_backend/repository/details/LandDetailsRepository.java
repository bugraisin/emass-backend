package com.emass.emass_backend.repository.details;

import com.emass.emass_backend.model.entity.listing.details.LandDetails;
import com.emass.emass_backend.model.entity.listing.details.OfficeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface LandDetailsRepository extends JpaRepository<LandDetails, Long>, JpaSpecificationExecutor<LandDetails> {
    Optional<LandDetails> findByListingId(Long id);
}
