package com.emass.emass_backend.model.dto.listing.details;

import com.emass.emass_backend.model.entity.enums.CommercialSubtype;

import java.math.BigDecimal;

public record CommercialDetailsRequest(
        CommercialSubtype subtype,
        Integer netArea,
        Integer floorNo,
        Integer buildingAge,
        Boolean furnished,
        Boolean airConditioning,
        Boolean parking,
        Boolean showcase,
        Integer streetFrontage,
        Boolean kitchen,
        Integer seatingCapacity,
        Boolean outdoorSeating,
        Boolean liquorLicense,
        Integer treatmentRoomCount,
        Boolean waitingArea,
        BigDecimal maintenanceFee
) {}
