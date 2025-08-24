package com.emass.emass_backend.repository.details;


import com.emass.emass_backend.model.entity.listing.details.HousingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface HousingDetailsRepository extends JpaRepository<HousingDetails, Long>, JpaSpecificationExecutor<HousingDetails> {
    Optional<HousingDetails> findByListingId(Long id);
}
