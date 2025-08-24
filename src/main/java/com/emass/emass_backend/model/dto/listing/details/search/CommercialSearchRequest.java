package com.emass.emass_backend.model.dto.listing.details.search;

import com.emass.emass_backend.model.entity.enums.CommercialSubtype;
import com.emass.emass_backend.model.entity.enums.ListingStatus;

import java.math.BigDecimal;

public record CommercialSearchRequest(
        // Listing filtreleri
        String city,
        String district,
        String neighborhood,
        BigDecimal minPrice,
        BigDecimal maxPrice,
        ListingStatus status,

        // CommercialDetails filtreleri
        CommercialSubtype subtype,
        Integer minNetArea,
        Integer maxNetArea,
        Integer floorNo,
        Integer minBuildingAge,
        Integer maxBuildingAge,
        Boolean furnished,
        Boolean airConditioning,
        Boolean parking,
        Boolean showcase,
        Integer minStreetFrontage,
        Integer maxStreetFrontage,
        Boolean kitchen,
        Integer minSeatingCapacity,
        Integer maxSeatingCapacity,
        Boolean outdoorSeating,
        Boolean liquorLicense,
        Integer minTreatmentRoomCount,
        Integer maxTreatmentRoomCount,
        Boolean waitingArea,
        BigDecimal minMaintenanceFee,
        BigDecimal maxMaintenanceFee
) {}