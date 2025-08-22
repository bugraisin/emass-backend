package com.emass.emass_backend.model.dto.listing.details;

import com.emass.emass_backend.model.entity.enums.OfficeSubtype;

import java.math.BigDecimal;

public record OfficeDetailsRequest(
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
