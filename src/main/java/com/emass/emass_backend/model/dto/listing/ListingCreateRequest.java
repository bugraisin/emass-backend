package com.emass.emass_backend.model.dto.listing;

import com.emass.emass_backend.model.dto.listing.details.*;
import com.emass.emass_backend.model.entity.enums.ListingType;
import com.emass.emass_backend.model.entity.enums.PropertyType;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

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
        Double latitude,
        Double longitude,
        List<MultipartFile> photos,

        // Conditional details - sadece biri dolu olacak
        HousingDetailsRequest housingDetails,
        CommercialDetailsRequest commercialDetails,
        OfficeDetailsRequest officeDetails,
        IndustrialDetailsRequest industrialDetails,
        ServiceDetailsRequest serviceDetails,
        LandDetailsRequest landDetails
) {}