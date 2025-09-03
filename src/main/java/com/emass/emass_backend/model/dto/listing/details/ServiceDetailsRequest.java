package com.emass.emass_backend.model.dto.listing.details;

import com.emass.emass_backend.model.entity.enums.ServiceSubtype;

import java.math.BigDecimal;

public record ServiceDetailsRequest(
        ServiceSubtype subtype,
        Integer grossArea,
        Integer netArea,
        Integer capacity,
        String spaceType,
        BigDecimal deposit,
        Boolean security,
        Boolean lighting,
        Boolean cctv,
        Boolean internet,
        Boolean reception,
        Boolean restRoom,
        Boolean kitchen,
        Boolean washingArea,
        Boolean maintenanceArea,
        Boolean airConditioning,
        Boolean ventilationSystem,
        Boolean storage,
        Boolean officeArea,
        Boolean customerParking
) {}

