package com.emass.emass_backend.repository.details;

import com.emass.emass_backend.model.entity.details.HousingDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HousingDetailsRepository extends JpaRepository<HousingDetails, Long> {
}
