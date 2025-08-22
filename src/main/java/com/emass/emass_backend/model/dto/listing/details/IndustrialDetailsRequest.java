package com.emass.emass_backend.model.dto.listing.details;

import com.emass.emass_backend.model.entity.enums.IndustrialSubtype;

import java.math.BigDecimal;

public record IndustrialDetailsRequest(
        IndustrialSubtype subtype,
        Integer totalArea,
        Integer coveredArea,
        Integer buildingAge,
        Integer ceilingHeight,
        Integer powerCapacity,
        Boolean crane,
        Integer craneCapacity,
        Boolean loadingDock,
        Integer loadingDockCount,
        Boolean truckAccess,
        Boolean coldStorage,
        String temperatureRange,
        Integer productionLineCount,
        Boolean laboratory,
        Integer officeArea,
        Boolean fireSystem,
        Boolean security,
        BigDecimal operatingCost
) {}
