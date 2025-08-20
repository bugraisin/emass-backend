package com.emass.emass_backend.model.dto.listing;

import com.emass.emass_backend.model.entity.enums.LandSubtype;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record LandDetailsRequest(
        @NotNull LandSubtype subtype,        // RESIDENTIAL_LAND, COMMERCIAL_LAND, FIELD, ...

        Integer areaM2,
        @Size(max = 40) String zoning,
        @Size(max = 50) String parcelNo,
        @Size(max = 50) String blockNo
) {
}
