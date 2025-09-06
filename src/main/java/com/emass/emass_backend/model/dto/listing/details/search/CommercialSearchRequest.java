package com.emass.emass_backend.model.dto.listing.details.search;

import com.emass.emass_backend.model.entity.enums.CommercialSubtype;
import com.emass.emass_backend.model.entity.enums.ListingStatus;
import com.emass.emass_backend.model.entity.enums.ListingType;
import com.emass.emass_backend.model.entity.enums.details.HeatingType;
import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.util.List;

public record CommercialSearchRequest(
        ListingType listingType,
        String city,
        List<String> district,
        List<String> neighborhood,
        BigDecimal minPrice,
        BigDecimal maxPrice,
        ListingStatus status,

        // CommercialDetails filtreleri
        CommercialSubtype subtype,

        Integer minNetArea,
        Integer maxNetArea,

        List<String> floors,
        List<String> buildingAges,

        BigDecimal minDeposit,
        BigDecimal maxDeposit,

        HeatingType heatingType,

        // Temel Özellikler
        Boolean furnished,

        Boolean parking,

        Boolean security,

        Boolean elevator,

        Boolean generator,

        // Konfor & Sistem
        Boolean airConditioning,

        Boolean internet,

        Boolean kitchen,

        Boolean toilet,

        // Özel Alanlar
        Boolean showcase,

        Boolean warehouse,

        Boolean loadingDock,

        Boolean cashRegister,

        // Müşteri Alanları
        Boolean outdoorSeating,

        Boolean waitingArea,

        Boolean changingRoom
) {}