package com.emass.emass_backend.model.dto.listing.details;

import com.emass.emass_backend.model.entity.enums.HeatingType;
import com.emass.emass_backend.model.entity.enums.HousingSubtype;

import java.math.BigDecimal;

public record HousingDetailsRequest(
        HousingSubtype subtype,
        String roomPlan,
        Integer netArea,
        Integer floorNo,
        Integer totalFloors,
        Integer buildingAge,
        Boolean furnished,
        Boolean balcony,
        Boolean parking,
        HeatingType heatingType,
        String siteName,
        BigDecimal siteFee
) {}
