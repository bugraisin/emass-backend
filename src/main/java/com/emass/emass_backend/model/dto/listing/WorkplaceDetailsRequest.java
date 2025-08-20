package com.emass.emass_backend.model.dto.listing;

import com.emass.emass_backend.model.entity.enums.WorkplaceSubtype;
import jakarta.validation.constraints.NotNull;

public record WorkplaceDetailsRequest(
        @NotNull WorkplaceSubtype subtype,   // SHOP, OFFICE, WAREHOUSE, ...

        Integer usableAreaM2,
        Integer floorNo,
        Double frontageM,
        Double ceilingHM
) {
}
