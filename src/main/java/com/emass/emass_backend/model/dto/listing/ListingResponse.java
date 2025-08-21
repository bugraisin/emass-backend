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
        HousingDetailsResponse housingDetails,
        WorkplaceDetailsResponse workplaceDetails,
        LandDetailsResponse landDetails
) {

    public record HousingDetailsResponse(
            HousingSubtype subtype,
            String roomPlan,
            Integer netArea,
            Integer floorNo,
            Integer totalFloors,
            Integer buildingAge,
            Boolean furnished,
            Boolean balcony,
            Boolean parking,
            HeatingType heatingType,
            String siteName,
            BigDecimal siteFee
    ) {}

    public record WorkplaceDetailsResponse(
            WorkplaceSubtype subtype,
            Integer netArea,
            Integer floorNo,
            Integer buildingAge,
            Boolean furnished,
            Boolean parking,
            Boolean airConditioning,
            Boolean kitchen,
            Integer seatingCapacity,
            BigDecimal maintenanceFee
    ) {}

    public record LandDetailsResponse(
            LandSubtype subtype,
            Integer totalArea,
            String zoningStatus,
            Boolean electricity,
            Boolean water,
            Boolean roadAccess,
            String titleDeedStatus
    ) {}
}
