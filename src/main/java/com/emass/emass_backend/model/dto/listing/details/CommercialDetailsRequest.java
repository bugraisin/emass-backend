package com.emass.emass_backend.model.dto.listing.details;

import com.emass.emass_backend.model.entity.enums.CommercialSubtype;
import com.emass.emass_backend.model.entity.enums.details.HeatingType;
import com.emass.emass_backend.model.entity.enums.details.BuildingType;

import java.math.BigDecimal;

public record CommercialDetailsRequest(
        CommercialSubtype subtype,
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
        Boolean security,
        Boolean elevator,
        Boolean generator,
        Boolean airConditioning,
        Boolean internet,
        Boolean kitchen,
        Boolean toilet,
        Boolean showcase,
        Boolean warehouse,
        Boolean loadingDock,
        Boolean cashRegister,
        Boolean outdoorSeating,
        Boolean waitingArea,
        Boolean changingRoom
) {}
