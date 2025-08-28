package com.emass.emass_backend.model.dto.listing.details;

import com.emass.emass_backend.model.entity.enums.IndustrialSubtype;

import java.math.BigDecimal;

public record IndustrialDetailsRequest(
        IndustrialSubtype subtype,
        Integer netArea,
        String buildingAge,
        Integer roomCount,
        Integer floorCount,
        BigDecimal ceilingHeight,
        BigDecimal siteFee,
        BigDecimal deposit,
        Boolean threephaseElectricity,
        Boolean naturalGasLine,
        Boolean steamLine,
        Boolean waterSystem,
        Boolean wasteWaterSystem,
        Boolean craneSystem,
        Boolean ventilationSystem,
        Boolean airConditioning,
        Boolean wideOpenArea,
        Boolean machineMountingSuitable,
        Boolean loadingRamp,
        Boolean truckEntrance,
        Boolean forkliftTraffic,
        Boolean rackingSystem,
        Boolean coldStorage,
        Boolean fireExtinguishingSystem,
        Boolean securityCameras,
        Boolean alarmSystem,
        Boolean fencedArea,
        Boolean security,
        BigDecimal operatingCost
) {}