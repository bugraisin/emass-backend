package com.emass.emass_backend.repository;

import com.emass.emass_backend.model.entity.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingRepository extends JpaRepository<Listing, Long> {
}
