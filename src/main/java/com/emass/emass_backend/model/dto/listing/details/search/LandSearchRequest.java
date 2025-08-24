package com.emass.emass_backend.model.dto.listing.details.search;

import com.emass.emass_backend.model.entity.enums.LandSubtype;
import com.emass.emass_backend.model.entity.enums.ListingStatus;

import java.math.BigDecimal;

public record LandSearchRequest(
        // Listing filtreleri
        String city,
        String district,
        String neighborhood,
        BigDecimal minPrice,
        BigDecimal maxPrice,
        ListingStatus status,

        // LandDetails filtreleri
        LandSubtype subtype,
        Integer minTotalArea,
        Integer maxTotalArea,
        String zoningStatus,
        Boolean electricity,
        Boolean water,
        Boolean roadAccess,
        String titleDeedStatus
) {}