package com.emass.emass_backend.model.dto.listing.details.search;

import com.emass.emass_backend.model.entity.enums.HousingSubtype;
import com.emass.emass_backend.model.entity.enums.ListingStatus;
import com.emass.emass_backend.model.entity.enums.ListingType;
import com.emass.emass_backend.model.entity.enums.ServiceSubtype;
import com.emass.emass_backend.model.entity.enums.details.SpaceType;
import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.util.List;

public record ServiceSearchRequest(
        // Listing filtreleri

        ListingType listingType,
        String city,
        List<String> district,
        List<String> neighborhood,

        // Price filtreleri (Price bileşeninden)
        BigDecimal minPrice,
        BigDecimal maxPrice,
        ListingStatus status,

        // ServiceDetails filtreleri
        ServiceSubtype subtype,
        // Alan filtreleri
        Integer minNetArea,
        Integer maxNetArea,

        Integer minCapacity,
        Integer maxCapacity,

        List<SpaceType> spaceTypes,

        BigDecimal minDeposit,
        BigDecimal maxDeposit,

        // Temel Altyapı
        Boolean security,
        Boolean lighting,
        Boolean cctv,
        Boolean internet,

        // Hizmet Alanları
        Boolean reception,
        Boolean restRoom,
        Boolean kitchen,

        // Teknik Donanım
        Boolean washingArea,
        Boolean maintenanceArea,
        Boolean airConditioning,
        Boolean ventilationSystem,

        // Ek Hizmetler
        Boolean storage,
        Boolean officeArea,
        Boolean customerParking
) {}