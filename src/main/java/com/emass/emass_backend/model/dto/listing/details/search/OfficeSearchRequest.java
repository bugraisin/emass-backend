package com.emass.emass_backend.model.dto.listing.details.search;

import com.emass.emass_backend.model.entity.enums.ListingStatus;
import com.emass.emass_backend.model.entity.enums.OfficeSubtype;

import java.math.BigDecimal;
import java.util.List;

public record OfficeSearchRequest (
        String city,
        String district,
        String neighborhood,
        BigDecimal minPrice,
        BigDecimal maxPrice,
        ListingStatus status,

        // OfficeDetails filtreleri
        OfficeSubtype subtype,
        Integer minNetArea,
        Integer maxNetArea,
        Integer floorNo,
        Integer minBuildingAge,
        Integer maxBuildingAge,
        Integer minRoomCount,
        Integer maxRoomCount,
        Integer minMeetingRoomCount,
        Integer maxMeetingRoomCount,
        Boolean furnished,
        Boolean airConditioning,
        Boolean parking,
        String businessCenter,
        Boolean reception,
        Integer minDeskCount,
        Integer maxDeskCount,
        Integer minPrivateOfficeCount,
        Integer maxPrivateOfficeCount,
        Integer minWorkstationCount,
        Integer maxWorkstationCount,
        Boolean soundIsolation,
        BigDecimal minMaintenanceFee,
        BigDecimal maxMaintenanceFee,
        Boolean internetIncluded
) {}
