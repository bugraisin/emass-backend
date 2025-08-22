package com.emass.emass_backend.model.dto.listing;

import com.emass.emass_backend.model.dto.listing.details.*;
import com.emass.emass_backend.model.entity.enums.ListingType;
import com.emass.emass_backend.model.entity.enums.PropertyType;

import java.math.BigDecimal;

public record ListingCreateRequest(
        Long ownerId,
        String title,
        String description,
        ListingType listingType,
        PropertyType propertyType,
        BigDecimal price,
        String city,
        String district,
        String neighborhood,
        String addressText,
        Double latitude,
        Double longitude,

        // Conditional details - sadece biri dolu olacak
        HousingDetailsRequest housingDetails,
        CommercialDetailsRequest commercialDetails,
        OfficeDetailsRequest officeDetails,
        IndustrialDetailsRequest industrialDetails,
        ServiceDetailsRequest serviceDetails,
        LandDetailsRequest landDetails
) {}