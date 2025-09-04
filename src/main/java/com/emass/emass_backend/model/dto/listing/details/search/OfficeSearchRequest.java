package com.emass.emass_backend.model.dto.listing.details.search;

import com.emass.emass_backend.model.entity.enums.ListingStatus;
import com.emass.emass_backend.model.entity.enums.ListingType;
import com.emass.emass_backend.model.entity.enums.OfficeSubtype;
import com.emass.emass_backend.model.entity.enums.details.FacadeDirection;
import com.emass.emass_backend.model.entity.enums.details.HeatingType;
import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.util.List;

public record OfficeSearchRequest (

        ListingType listingType,
        String city,
        List<String> district,
        List<String> neighborhood,
        BigDecimal minPrice,
        BigDecimal maxPrice,
        ListingStatus status,

        OfficeSubtype subtype,

        Integer minNetArea,
        Integer maxNetArea,

        List<String> floors,
        List<String> buildingAges,

        List<String> roomCount,
        List<String> meetingRooms,
        List<FacadeDirection> facadeDirections,
        List<HeatingType> heatingTypes,

        BigDecimal minSiteFee,
        BigDecimal maxSiteFee,
        BigDecimal minDeposit,
        BigDecimal maxDeposit,

        // Temel Özellikler
        Boolean furnished,
        Boolean parking,
        Boolean elevator,
        Boolean security,
        Boolean generator,

        // Ofis Konfor
        Boolean airConditioning,
        Boolean internet,
        Boolean kitchen,
        Boolean fireSystem,

        // Çalışma Alanları
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
