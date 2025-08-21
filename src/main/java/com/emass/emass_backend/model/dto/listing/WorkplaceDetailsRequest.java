package com.emass.emass_backend.model.dto.listing;

import com.emass.emass_backend.model.entity.enums.WorkplaceSubtype;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record WorkplaceDetailsRequest(
        @NotNull WorkplaceSubtype subtype,
        Integer netArea,
        Integer floorNo,
        Integer buildingAge,
        Boolean furnished,
        Boolean parking,
        Boolean airConditioning,
        Boolean kitchen,
        Integer seatingCapacity,
        BigDecimal maintenanceFee
) {}
