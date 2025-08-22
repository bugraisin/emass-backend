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

        // Detail responses - sadece biri dolu olacak
        HousingDetailsResponse housingDetails,
        CommercialDetailsResponse commercialDetails,
        OfficeDetailsResponse officeDetails,
        IndustrialDetailsResponse industrialDetails,
        ServiceDetailsResponse serviceDetails,
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

    public record CommercialDetailsResponse(
            CommercialSubtype subtype,
            Integer netArea,
            Integer floorNo,
            Integer buildingAge,
            Boolean furnished,
            Boolean airConditioning,
            Boolean parking,
            Boolean showcase,
            Integer streetFrontage,
            Boolean kitchen,
            Integer seatingCapacity,
            Boolean outdoorSeating,
            Boolean liquorLicense,
            Integer treatmentRoomCount,
            Boolean waitingArea,
            BigDecimal maintenanceFee
    ) {}

    public record OfficeDetailsResponse(
            OfficeSubtype subtype,
            Integer netArea,
            Integer floorNo,
            Integer buildingAge,
            Integer roomCount,
            Integer meetingRoomCount,
            Boolean furnished,
            Boolean airConditioning,
            Boolean parking,
            String businessCenter,
            Boolean reception,
            Integer deskCount,
            Integer privateOfficeCount,
            Integer workstationCount,
            Boolean soundIsolation,
            BigDecimal maintenanceFee,
            Boolean internetIncluded
    ) {}

    public record IndustrialDetailsResponse(
            IndustrialSubtype subtype,
            Integer totalArea,
            Integer coveredArea,
            Integer buildingAge,
            Integer ceilingHeight,
            Integer powerCapacity,
            Boolean crane,
            Integer craneCapacity,
            Boolean loadingDock,
            Integer loadingDockCount,
            Boolean truckAccess,
            Boolean coldStorage,
            String temperatureRange,
            Integer productionLineCount,
            Boolean laboratory,
            Integer officeArea,
            Boolean fireSystem,
            Boolean security,
            BigDecimal operatingCost
    ) {}

    public record ServiceDetailsResponse(
            ServiceSubtype subtype,
            Integer totalArea,
            Integer coveredArea,
            Integer vehicleCapacity,
            String coverType,
            Integer heightLimit,
            Boolean valetService,
            Boolean equipmentIncluded,
            Integer changingRoomCount,
            Integer showerCount,
            Boolean sauna,
            Integer washBayCount,
            Boolean automaticSystem,
            Integer liftCount,
            Integer liftCapacity,
            Boolean paintBooth,
            Integer pumpCount,
            String fuelTypes,
            Boolean convenienceStore,
            Boolean security,
            Boolean lighting,
            BigDecimal operatingCost
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
