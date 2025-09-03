package com.emass.emass_backend.model.dto.listing.details.search;

import com.emass.emass_backend.model.entity.enums.ListingStatus;
import com.emass.emass_backend.model.entity.enums.ServiceSubtype;

import java.math.BigDecimal;

public record ServiceSearchRequest(
        // Listing filtreleri
        String city,
        String district,
        String neighborhood,
        BigDecimal minPrice,
        BigDecimal maxPrice,
        ListingStatus status,

        // ServiceDetails filtreleri
        ServiceSubtype subtype,
        Integer minTotalArea,
        Integer maxTotalArea,
        Integer minCoveredArea,
        Integer maxCoveredArea,
        Integer minVehicleCapacity,
        Integer maxVehicleCapacity,
        String coverType,
        Integer minHeightLimit,
        Integer maxHeightLimit,
        Boolean valetService,
        Boolean equipmentIncluded,
        Integer minChangingRoomCount,
        Integer maxChangingRoomCount,
        Integer minShowerCount,
        Integer maxShowerCount,
        Boolean sauna,
        Integer minWashBayCount,
        Integer maxWashBayCount,
        Boolean automaticSystem,
        Integer minLiftCount,
        Integer maxLiftCount,
        Integer minLiftCapacity,
        Integer maxLiftCapacity,
        Boolean paintBooth,
        Integer minPumpCount,
        Integer maxPumpCount,
        String fuelTypes,
        Boolean convenienceStore,
        Boolean security,
        Boolean lighting
) {}