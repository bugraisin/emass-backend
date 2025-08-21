package com.emass.emass_backend.model.dto.listing;

import com.emass.emass_backend.model.entity.enums.HeatingType;
import com.emass.emass_backend.model.entity.enums.HousingSubtype;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record HousingDetailsRequest(
        @NotNull HousingSubtype subtype,
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
