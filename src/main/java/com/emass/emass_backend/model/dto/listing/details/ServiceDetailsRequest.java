package com.emass.emass_backend.model.dto.listing.details;

import com.emass.emass_backend.model.entity.enums.ServiceSubtype;

import java.math.BigDecimal;

public record ServiceDetailsRequest(
        ServiceSubtype subtype,
        Integer totalArea,
        Integer coveredArea,
        Integer vehicleCapacity,
        String coverType,
        Integer heightLimit,
        Boolean valetService,
        Boolean equipmentIncluded,
        Integer changingRoomCount,
        Integer showerCount,
        Boolean sauna,
        Integer washBayCount,
        Boolean automaticSystem,
        Integer liftCount,
        Integer liftCapacity,
        Boolean paintBooth,
        Integer pumpCount,
        String fuelTypes,
        Boolean convenienceStore,
        Boolean security,
        Boolean lighting,
        BigDecimal operatingCost
) {}
