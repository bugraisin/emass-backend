package com.emass.emass_backend.model.dto.listing;

import com.emass.emass_backend.model.entity.enums.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ListingResponse(
        Long id,
        Long ownerId,

        String title,
        String description,

        ListingType listingType,
        PropertyType propertyType,
        ListingStatus status,

        BigDecimal price,

        String city,
        String district,
        String neighborhood,
        String addressText,
        Double latitude,
        Double longitude,

        LocalDateTime createdAt,
        LocalDateTime updatedAt,

        // Detay bloklarından YALNIZCA biri dolu olmalı:
        HousingDetailsResponse housingDetails,
        WorkplaceDetailsResponse workplaceDetails,
        LandDetailsResponse landDetails

) {

    public record HousingDetailsResponse(
            HousingSubtype subtype,
            String roomPlan,
            Integer floorNo,
            Integer totalFloors,
            Integer buildingAge,
            Boolean furnished,
            Integer netAreaM2,
            Integer grossAreaM2
    ) {}

    public record WorkplaceDetailsResponse(
            WorkplaceSubtype subtype,
            Integer usableAreaM2,
            Integer floorNo,
            Double frontageM,
            Double ceilingHM
    ) {}

    public record LandDetailsResponse(
            LandSubtype subtype,
            Integer areaM2,
            String zoning,
            String parcelNo,
            String blockNo
    ) {}
}
