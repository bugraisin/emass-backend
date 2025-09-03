package com.emass.emass_backend.model.dto.listing.details.search;

import com.emass.emass_backend.model.entity.enums.IndustrialSubtype;
import com.emass.emass_backend.model.entity.enums.ListingStatus;

import java.math.BigDecimal;

public record IndustrialSearchRequest(
        // Listing filtreleri
        String city,
        String district,
        String neighborhood,
        BigDecimal minPrice,
        BigDecimal maxPrice,
        ListingStatus status,

        // IndustrialDetails filtreleri
        IndustrialSubtype subtype,
        Integer minTotalArea,
        Integer maxTotalArea,
        Integer minCoveredArea,
        Integer maxCoveredArea,
        Integer minBuildingAge,
        Integer maxBuildingAge,
        Integer minCeilingHeight,
        Integer maxCeilingHeight,
        Integer minPowerCapacity,
        Integer maxPowerCapacity,
        Boolean crane,
        Integer minCraneCapacity,
        Integer maxCraneCapacity,
        Boolean loadingDock,
        Integer minLoadingDockCount,
        Integer maxLoadingDockCount,
        Boolean truckAccess,
        Boolean coldStorage,
        String temperatureRange,
        Integer minProductionLineCount,
        Integer maxProductionLineCount,
        Boolean laboratory,
        Integer minOfficeArea,
        Integer maxOfficeArea,
        Boolean fireSystem,
        Boolean security
) {}