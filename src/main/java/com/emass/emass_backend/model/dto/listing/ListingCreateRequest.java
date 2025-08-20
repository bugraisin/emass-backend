package com.emass.emass_backend.model.dto.listing;

import com.emass.emass_backend.model.entity.enums.ListingType;
import com.emass.emass_backend.model.entity.enums.PropertyType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ListingCreateRequest(
        @NotNull Long ownerId,

        @NotBlank @Size(max = 200) String title,
        @Size(max = 10_000) String description,

        @NotNull ListingType listingType,     // SALE | RENT
        @NotNull PropertyType propertyType,   // HOUSING | WORKPLACE | LAND

        @NotNull @DecimalMin(value = "0.0", inclusive = false) BigDecimal price,

        @NotBlank @Size(max = 100) String city,
        @NotBlank @Size(max = 100) String district,
        @Size(max = 120) String neighborhood,
        @Size(max = 255) String addressText,

        @Valid HousingDetailsRequest housingDetails,
        @Valid WorkplaceDetailsRequest workplaceDetails,
        @Valid LandDetailsRequest landDetails
        ) {}