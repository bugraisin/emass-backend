package com.emass.emass_backend.model.dto.listing.details.search;

import com.emass.emass_backend.model.entity.enums.IndustrialSubtype;
import com.emass.emass_backend.model.entity.enums.ListingStatus;
import com.emass.emass_backend.model.entity.enums.ListingType;
import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.util.List;

public record IndustrialSearchRequest(
        ListingType listingType,
        String city,
        List<String> district,
        List<String> neighborhood,

        // Price filtreleri (Price bileşeninden)
        BigDecimal minPrice,
        BigDecimal maxPrice,
        ListingStatus status,

        // IndustrialDetails filtreleri
        IndustrialSubtype subtype,

        Integer minNetArea,
        Integer maxNetArea,
        List<String> buildingAges,
        Integer minCeilingHeight,
        Integer maxCeilingHeight,

        // Altyapı & Enerji
        Boolean threephaseElectricity,
        Boolean naturalGasLine,
        Boolean steamLine,
        Boolean waterSystem,
        Boolean wasteWaterSystem,

        // Üretim & İmalat
        Boolean craneSystem,
        Boolean ventilationSystem,
        Boolean airConditioning,
        Boolean wideOpenArea,
        Boolean machineMountingSuitable,

        // Depolama & Lojistik
        Boolean loadingRamp,
        Boolean truckEntrance,
        Boolean forkliftTraffic,
        Boolean rackingSystem,
        Boolean coldStorage,

        // Güvenlik & Sistem
        Boolean fireExtinguishingSystem,
        Boolean securityCameras,
        Boolean alarmSystem,
        Boolean fencedArea,
        Boolean security
) {}