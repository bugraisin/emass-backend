package com.emass.emass_backend.model.dto.listing;

import com.emass.emass_backend.model.dto.listing.details.*;
import com.emass.emass_backend.model.entity.enums.ListingType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record ListingUpdateRequest(
        @NotBlank @Size(max = 200) String title,
        @Size(max = 10_000) String description,
        ListingType listingType,
        @DecimalMin(value = "0.0", inclusive = false) BigDecimal price,
        @Size(min = 3, max = 3) String currency,

        @Size(max = 100) String city,
        @Size(max = 100) String district,
        @Size(max = 120) String neighborhood,
        Double latitude,
        Double longitude,

        // YENİ: Tüm kategori detail'leri - sadece biri dolu olacak
        @Valid HousingDetailsRequest housingDetails,
        @Valid CommercialDetailsRequest commercialDetails,
        @Valid OfficeDetailsRequest officeDetails,
        @Valid IndustrialDetailsRequest industrialDetails,
        @Valid ServiceDetailsRequest serviceDetails,
        @Valid LandDetailsRequest landDetails
) {}
