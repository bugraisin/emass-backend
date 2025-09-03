package com.emass.emass_backend.model.dto.listing.details;

import com.emass.emass_backend.model.entity.enums.OfficeSubtype;
import com.emass.emass_backend.model.entity.enums.details.HeatingType;
import com.emass.emass_backend.model.entity.enums.details.BuildingType;

import java.math.BigDecimal;

public record OfficeDetailsRequest(
        OfficeSubtype subtype,
        Integer grossArea,
        Integer netArea,
        String buildingAge,
        Integer roomCount,
        Integer floorNo,
        Integer floorCount,
        HeatingType heatingType,
        BigDecimal siteFee,
        BigDecimal deposit,
        BuildingType buildingType,
        Boolean furnished,
        Boolean parking,
        Boolean elevator,
        Boolean security,
        Boolean generator,
        Boolean airConditioning,
        Boolean internet,
        Boolean kitchen,
        Boolean fireSystem,
        Boolean reception,
        Boolean waitingArea,
        Boolean meetingRoom,
        Boolean archive,
        Boolean library,
        Boolean serverRoom,
        Boolean accessControl,
        Boolean fiberInternet,
        Boolean soundproof
) {}
