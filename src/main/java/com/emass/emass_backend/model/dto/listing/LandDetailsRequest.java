package com.emass.emass_backend.model.dto.listing;

import com.emass.emass_backend.model.entity.enums.LandSubtype;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record LandDetailsRequest(
        @NotNull LandSubtype subtype,
        Integer totalArea,
        String zoningStatus,
        Boolean electricity,
        Boolean water,
        Boolean roadAccess,
        String titleDeedStatus
) {}
