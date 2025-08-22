package com.emass.emass_backend.model.dto.listing.details;

import com.emass.emass_backend.model.entity.enums.LandSubtype;
import jakarta.validation.constraints.NotNull;

public record LandDetailsRequest(
        LandSubtype subtype,
        Integer totalArea,
        String zoningStatus,
        Boolean electricity,
        Boolean water,
        Boolean roadAccess,
        String titleDeedStatus
) {}
