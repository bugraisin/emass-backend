package com.emass.emass_backend.model.dto.listing.details.search;

import com.emass.emass_backend.model.entity.enums.details.HeatingType;
import com.emass.emass_backend.model.entity.enums.HousingSubtype;
import com.emass.emass_backend.model.entity.enums.ListingStatus;

import java.math.BigDecimal;
import java.util.List;

public record HouseSearchRequest(
        // Listing filtreleri
        String city,
        String district,
        String neighborhood,
        BigDecimal minPrice,
        BigDecimal maxPrice,
        ListingStatus status,

        // HouseDetails filtreleri
        HousingSubtype subtype,
        List<String> roomPlans,  // artık birden fazla oda planı destekleniyor
        Integer minNetArea,
        Integer maxNetArea,
        Integer floorNo,
        Integer totalFloors,
        Integer buildingAge,
        Boolean furnished,
        Boolean balcony,
        Boolean parking,
        HeatingType heatingType,
        String siteName,
        BigDecimal minSiteFee,
        BigDecimal maxSiteFee
) {}
