package com.emass.emass_backend.model.dto.listing;

import com.emass.emass_backend.model.entity.enums.HousingSubtype;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record HousingDetailsRequest(
        @NotNull HousingSubtype subtype,     // APARTMENT, VILLA, REZIDANS, ...

        @Size(max = 10) String roomPlan,
        Integer floorNo,
        Integer totalFloors,
        Integer buildingAge,
        Boolean furnished,
        Integer netAreaM2,
        Integer grossAreaM2
) {}
