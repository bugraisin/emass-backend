package com.emass.emass_backend.repository.details;

import com.emass.emass_backend.model.entity.details.LandDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LandDetailsRepository extends JpaRepository<LandDetails, Long> {
    Optional<LandDetails> findByListingId(Long id);
}
